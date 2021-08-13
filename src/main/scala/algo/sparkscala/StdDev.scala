package algo.sparkscala

//import org.apache.hadoop.hive.ql.exec.UDF
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{SparkSession, SQLContext}
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions._

object StdDev {
  def main(arg:Array[String]):Unit={
    Logger.getRootLogger.setLevel(Level.ERROR)

    val sparkSession= SparkSession.builder().appName("stddev").enableHiveSupport().getOrCreate()

    val logger:Logger = Logger.getRootLogger
    val sqlContext:SQLContext = sparkSession.sqlContext

    sparkSession.sparkContext.setLogLevel("ERROR")

    def getstdev() = udf{ spendList:Seq[Double]=>
        val n = spendList.length
        val mean = spendList.sum/n
        Math.sqrt(spendList.foldLeft(0.0)((prevSum,ele) => prevSum+(ele-mean)*(ele-mean))/n)}


    val trans = sqlContext.read.table("tesco_uk_media_media_mart.transactions")
    trans.select("customer","spendamount","fis_week_id").
      where("fis_week_id in ('202101')").
      withColumn("spendamount",col("spendamount").cast("Double")).
      groupBy("customer","fis_week_id").
      agg(collect_list("spendamount").as("spendlist")).
      withColumn("stddev",getstdev()(col("spendlist"))).
      show(10,false)


    val maxweek:String = trans.where("fis_week_id = '202101'").select(max(col("date_id")).as("date_id")).
      withColumn("week",concat(year(col("date_id")),lpad(weekofyear(col("date_id")),2,"0"))).
      repartition(1).collect()(0)(1).asInstanceOf[String]

    def getlast(maxWeek:String,n:Int):List[String]={
      val year  =maxweek.slice(0,4)
      val week  =maxweek.slice(4,6).toInt
      if (week.toInt>=n) (week-n to week).toList.map(s"$year%02d".format(_))
      else {
        val prevYear = (year.toInt-1).toString
        (52-n+week to 52).toList.map(s"$prevYear%02d".format(_)) ::: (1 to week).toList.map(s"$year%02d".format(_))
      }
    }
  }
}

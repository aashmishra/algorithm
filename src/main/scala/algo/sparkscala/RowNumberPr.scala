package algo.sparkscala

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import spray.json._
object RowNumberPr {
  def main(args: Array[String]): Unit = {

    val spark:SparkSession = SparkSession.
      builder().
      appName("rownum").
      enableHiveSupport().
      getOrCreate()

    val data = spark.read.table("sometable")
    val window = Window.partitionBy("customer").orderBy(col("date").desc_nulls_last).
      rowsBetween(Window.unboundedPreceding, Window.currentRow)
    val finall = data.withColumn("rank",rank().over(window))
    finall.show(100, truncate = false)


//    val str =
//      """
//        |{
//        |rank:{
//        |"A":"80-100",
//        |"B":"50-79",
//        |"C":"30-49"
//        |}
//        |}
//      """.stripMargin
//    import spark.implicits._
//    val  info= spark.read.json(Seq(str).toDS)
//    val st= info.withColumn("grade", )

  }

}

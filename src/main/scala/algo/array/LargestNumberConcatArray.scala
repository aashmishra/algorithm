package algo.array

object LargestNumberConcatArray extends App{

  def largestNumber(nums: Array[Int]): String = {
    if(nums.distinct(0)==0 & nums.distinct.length==1) return "0"
    nums.sortWith((a,b)=>  a.toString + b.toString >  b.toString + a.toString ).mkString("")
  }

  val data = Array(3,30,34,5,9)
  println(largestNumber(data))
}

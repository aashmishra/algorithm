package algo.array

object MaximumProductOfTwoNumbers extends App{
  def maxProduct(nums: Array[Int]): Int = {
    nums.map(_-1).sorted.slice(nums.length-2,nums.length).product
  }

  val data= Array(1,5,4,5 )
  println(maxProduct(data))
}

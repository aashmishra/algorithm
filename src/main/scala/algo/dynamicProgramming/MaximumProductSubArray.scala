package algo.dynamicProgramming

object MaximumProductSubArray extends App {
  def maxProduct(nums: Array[Int]): Int = {

    nums.foldLeft(1,1,nums.max){ case ((max,min,result),currentElement)=>
      val newMax = Math.max(Math.max(currentElement, max*currentElement), min*currentElement)
      val newMin = Math.min(Math.min(currentElement, max*currentElement), min*currentElement)
      (newMax, newMin, Math.max(newMax,result))
    }._3
  }

  val data= Array(-1,3,-2)
  /// 2  6
  //  1  1 -2
  println(maxProduct(data))
}

package algo.array

object Maximumsubarray extends App {

  def maxSubArray(nums: Array[Int]): Int = {
    val (currentMax:Int, globalMax:Int) = (nums(0),nums(0))
    nums.slice(1,nums.length).foldLeft(currentMax,globalMax){ case ((curMax, gloMax), currentValue)=>
//      println("loop start")
//      println(s"curMax=> ${curMax},currentValue=> ${gloMax}, currentValue=>${currentValue}")
      val newCurrentMax = math.max(currentValue,currentValue+curMax)
      val newGlobalMax = math.max(gloMax, newCurrentMax)
//      println(s"newCurrentMax=> ${newCurrentMax},newGlobalMax=> ${newGlobalMax}")
//      println("loop start")
      (newCurrentMax,newGlobalMax)

    }._2

  }

  val data= Array(1,2,5,-10,7,8,9)
  print(maxSubArray(data))
//  data.slice(1,data.length).foreach(println(_))
}

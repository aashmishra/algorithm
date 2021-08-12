package algo.array

object KadansAlgorithmMaxSubArray extends App {

  def maxSubArrayIndex(input: Array[Int]): (Int, Int) = {


    var startIndex = 0
    var globalStartIndex = 0
    var endIndex = 0
    var globalEndIndex = 0
    var currentMax = Integer.MIN_VALUE
    var globalMAx = Integer.MIN_VALUE
    for (index <- input.indices) {
      if (input(index) + currentMax < input(index)) {
        currentMax = input(index)
        startIndex = index
        endIndex = index
      }
      else {
        currentMax = input(index) + currentMax
        endIndex = index
      }

      if (currentMax > globalMAx) {
        globalStartIndex = startIndex
        globalEndIndex = endIndex
        globalMAx = currentMax
      }

    }
    (globalStartIndex, globalEndIndex)

  }

  val data  = Array(1,2,3,4,-20,10,10,5,-3,-3,150)
  val maxIndex = maxSubArrayIndex(data)
  println(data.slice(maxIndex._1, maxIndex._2+1).sum)
  println(maxIndex._1+","+ maxIndex._2)



}

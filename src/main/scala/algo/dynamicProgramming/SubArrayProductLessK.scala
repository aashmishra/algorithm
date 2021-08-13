package algo.dynamicProgramming

object SubArrayProductLessK extends App {

  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    var start = 0
//    var end = 0
    var product=1
    var result = 0
    for(end<- nums.indices){
      product = product*nums(end)

      while(start<end & product>=k){
        product=product/nums(start)
        start+=1
      }
      if(product<k){
        result+= end-start+1
      }

    }
    result
  }

  val data = Array(10, 5, 2, 6)
  println(numSubarrayProductLessThanK(data, 100))
}

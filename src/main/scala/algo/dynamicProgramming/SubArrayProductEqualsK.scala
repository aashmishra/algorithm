package algo.dynamicProgramming

object SubArrayProductEqualsK extends  App {

  def subarrayProduct(nums: Array[Int], k: Int): Int = {
    var start = 0
    var end = 0
    var product=1
    var result = 0
    while(end< nums.length){
      product = product*nums(end)

      while(start<end && product>k){
        product=product/nums(start)
        start+=1
      }

      if(product==k){
        var oneCount=0
        while(end+1<nums.length && nums(end+1)==1){
          oneCount+=1
          end+=1
        }
        result+=oneCount+1
        while (start<=end && nums(start)==1){
          result+=oneCount+1
          start+=1
        }
        product = product/nums(start)
        start+=1
      }
      end+=1

    }
    result
  }


  val data = Array(1,1,1)
  println(subarrayProduct(data,2))
}

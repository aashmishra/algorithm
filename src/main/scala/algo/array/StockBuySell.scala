package algo.array

object StockBuySell extends App{


    def maxProfit(prices: Array[Int]): Int = {
      var min:Int = Integer.MAX_VALUE
      var minIndex = 0
      var maxDiff = 0
      var maxIndex = 0
//      var minArray = new Array[Int](prices.length)
      for(i<-prices.indices){
          if(prices(i)<prices(minIndex)) {
            minIndex = i
//            println("minIndex "+minIndex)
          }
        //        minArray(i) = minIndex
        if(((prices(i) - prices(minIndex)) > maxDiff) & minIndex<i){
          maxDiff=prices(i) - prices(minIndex)
//          println("maxDiff "+maxDiff)
          maxIndex = i
        }

      }

      maxDiff
    }


  val data = Array(7,1,5,3,6,4);
  println(maxProfit(data))

}

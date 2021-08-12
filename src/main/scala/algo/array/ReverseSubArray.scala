package algo.array
import scala.collection.immutable

object ReverseSubArray extends App{

    //Function to reverse every sub-array group of size k.
    def reverseInGroups(arr: Array[Int], n: Int, k: Int) {
      // code here
      var totalPair = n / k
      val data = new Array[Int](n)
      (1 to totalPair).foreach { pair =>
        val setOfIndexes: immutable.Seq[(Int, Int)] =
          (pair * k - k until pair * k) zip (pair * k-1 to pair * k - k by -1)
        setOfIndexes.foreach(println)
        setOfIndexes.foreach {
          case (x, y)=> data(x)=arr(y)

      }
      }

  }

  val data = Array(1 ,2 ,3 ,4 ,5 )
  reverseInGroups(data, 5,3)
}



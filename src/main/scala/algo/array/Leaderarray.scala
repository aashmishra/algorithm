package algo.array

object Leaderarray extends App{

  import java.util

  def leaders(arr: Array[Int], n: Int):Array[Int] = {
    // Your code here
    var list:List[Int]=List()
    var currentMax = -1
    for (x<- n-1 to 0 by -1){
    if(arr(x)>currentMax){
      list=list.::( arr(x))
      currentMax=arr(x)
    }
    }
     list.toArray
  }

  val data=Array(10,4,9,1,1)
  leaders(data,5).foreach(println(_))
}

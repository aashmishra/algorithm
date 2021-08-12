package algo.stack

object largestRectangleAreaScala extends App{

  case class Pair(value:Int,index:Int)
  def nextSmallestLeft(heights: Array[Int]):Array[Int]={
    var s = scala.collection.mutable.Stack[Pair]()
    var res = Array.ofDim[Int](heights.length)
    for(index<-heights.indices){
    while(s.nonEmpty && s.top.value>=heights(index)){
      s.pop
    }
      if(s.isEmpty){
        res(index)=index
      } else {res(index)=index-s.top.index-1}
      s.push(Pair(heights(index),index))
    }
    res
  }
  def nextSmallestRight(heights: Array[Int]):Array[Int]={
    var ss = scala.collection.mutable.Stack[Pair]()
    var ress = Array.ofDim[Int](heights.length)
    for(index<-(heights.length-1) to 0 by -1){
      while(ss.nonEmpty && ss.top.value>=heights(index)){
        ss.pop
      }
      if(ss.isEmpty){
        ress(index)=heights.length-index-1
      } else {ress(index)=ss.top.index-index-1}
      ss.push(Pair(heights(index),index))
    }
    ress
  }
  def largestRectangleArea(heights: Array[Int]): Int = {
   var max= Integer.MIN_VALUE
    val h1= nextSmallestLeft(heights)
    val h2= nextSmallestRight(heights)
    for(index <-heights.indices ){
      max= Math.max(max,(h1(index)+h2(index)+1)*heights(index))
    }
    max
  }

//  var data = Array(1,2,3,2,1)
  var data = Array(1)
  nextSmallestLeft(data).foreach(x=>print(x+","))
  println("")
  nextSmallestRight(data).foreach(x=>print(x+","))
  println("")
  println(largestRectangleArea(data))
}

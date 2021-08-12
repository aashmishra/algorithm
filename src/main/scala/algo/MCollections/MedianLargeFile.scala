package algo.MCollections

import java.io.File

object MedianLargeFile extends App{

 val data = new File("C:\\dev\\falcon")

  // how to read a file in stream
  val lis = List(1,2,3,4,5,6)
    lis.map(new Function[Int,Int] {
      def apply(x:Int):Int=x+1
    })


  def even(x:Int):Boolean ={x%2==0}
  lis.toIterator


  trait P {
    def apply(S:String)=println(S+"added")
  }

  new P{("hi")}



}

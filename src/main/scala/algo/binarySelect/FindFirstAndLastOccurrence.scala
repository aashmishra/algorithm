package algo.binarySelect

import scala.annotation.tailrec

object FindFirstAndLastOccurrence  extends App {

  @tailrec
  def binarySelectStartEnd(arr:Array[Int], start:Int, end:Int, search:Int, index:Int, findType:String): Int ={
    if (end<start) index
    else {
      val mid=start+(end-start)/2
      arr(mid) match {
        case midElem if midElem>search =>binarySelectStartEnd(arr,start,mid-1,search,index,findType)
        case midElem if midElem<search => binarySelectStartEnd(arr,mid+1,end,search,index,findType)
        case midElem if midElem==search && findType=="start" =>binarySelectStartEnd(arr,start,mid-1,search,mid, findType)
        case midElem if midElem==search && findType=="end" =>binarySelectStartEnd(arr,mid+1,end,search,mid, findType)
      }
    }
  }

  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val startIndex = binarySelectStartEnd(nums,0,nums.length-1,target,-1,"start")
    val endIndex = binarySelectStartEnd(nums,startIndex+1,nums.length-1,target,startIndex,"end")
    Array(startIndex,endIndex)
  }

  def searchFirstAndLastIndex(array: Array[Int],search:Int):(Int, Int)={
    val startIndex = binarySelectStartEnd(array,0,array.length-1,search,-1,"start")
    val endIndex = binarySelectStartEnd(array,0,array.length-1,search,startIndex,"end")
    (startIndex,endIndex)
  }

  val data = Array(5,7,7,8,8,10)
  println(searchFirstAndLastIndex(data,8))
}

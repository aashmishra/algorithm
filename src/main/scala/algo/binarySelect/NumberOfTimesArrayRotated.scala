package algo.binarySelect

import scala.annotation.tailrec

object NumberOfTimesArrayRotated extends App {
  @tailrec
  def rotationBinarySearchIndex(array: Array[Int],start:Int,end:Int):Int={
    val len = array.length
    val mid = start+ (end-start)/2
    if(start>end) return mid
    val next= (mid+1)%len
    val prev= (mid+len-1)%len
    if(array(mid)<=array(next) && array(mid)<=array(prev)) return mid
    if(array(mid)>=array(end)) rotationBinarySearchIndex(array,mid+1,end)
    else rotationBinarySearchIndex(array,start,mid-1)
  }
  @tailrec
  def binarySearch(array: Array[Int],search:Int,start:Int,end:Int):Int={
    if(start>end) return -1
    val mid = start+ (end-start)/2
    if(array(mid)==search) return mid
    if(array(mid)>search) binarySearch(array,search,start,mid-1)
    else binarySearch(array,search,mid+1,end)
  }

  def search(array: Array[Int], target:Int):Int={
    val minIndex = rotationBinarySearchIndex(array,0,array.length-1)
    println("minIndex-->"+minIndex)
    if(target>=array(minIndex) && target<=array(array.length-1)){
      binarySearch(array,target,minIndex,array.length-1)
    } else { binarySearch(array,target,0,minIndex) }
  }

  val data = Array(1,3,3)
//  println(rotationBinarySearchIndex(data,0,data.length-1))
  println(search(data,1))
}

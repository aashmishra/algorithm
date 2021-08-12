package algo.binarySelect

object FindMinInRotated extends App {
  def rotationBinarySearchIndex(array: Array[Int],start:Int,end:Int):Int={
    val len = array.length
    val mid = start+ (end-start)/2
    if(start>end) return start
    val next= (mid+1)%len
    val prev= (mid+len-1)%len
    if(array(start)==array(end)) return rotationBinarySearchIndex(array,start,end-1)
    if(array(mid)<=array(next) && array(mid)<array(prev)) {return mid}
    if(array(mid)>array(end)) rotationBinarySearchIndex(array,mid+1,end)
    else rotationBinarySearchIndex(array,start,mid-1)
  }

  def findMin(nums: Array[Int]): Int = {
    val aminIndex = rotationBinarySearchIndex(nums,0,nums.length-1)
//    println(aminIndex)
    val minIndex = aminIndex%nums.length
    nums(minIndex)
  }

  val data = Array(1,3,3)
//  val data = Array(3,1,1,1,1)
//  val data = Array(3,3,1,3)
  println(findMin(data))
}

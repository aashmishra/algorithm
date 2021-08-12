package algo.array

import scala.collection.mutable

object PermutationArray extends App{

  def swap(nums: Array[Int], i:Int, j:Int):Array[Int]={
    val temp= nums(i)
     nums(i)= nums(j)
     nums(j)= temp
    nums
  }

  def permuteArray(nums:Array[Int], start:Int, end:Int):  List[List[Int]] ={
    var result :List[List[Int]] = List.empty
    if(start==end-1){
      result =  List(nums.toList)
    } else {
      for(i<- start until end){
        swap(nums,start,i)
        result = result ++ permuteArray(nums, start+1,end)
        swap(nums,start,i)
      }
    }
    result
  }

  def permute(nums: Array[Int]): List[List[Int]] = {
    permuteArray(nums, 0, nums.length)
  }

  val data = Array(1)
  permute(data).foreach(println(_))
}

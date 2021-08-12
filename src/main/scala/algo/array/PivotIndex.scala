package algo.array

import scala.annotation.tailrec
import scala.util.control.Breaks

object PivotIndex extends App{
  def pivotIndex(nums: Array[Int]): Int = {
    var pivotIndex = -1
    var cum=0

    if(nums.length==1){
      pivotIndex= nums(0)
      return nums(0)
    } else if (nums.length==2){
      pivotIndex= nums(0)
      return -1
    }


    val cumsum = new Array[Int](nums.length)
    for(x <- nums.indices){
        cum+=nums(x)
        cumsum(x)=cum
      }

    val innerloop = new Breaks
    innerloop.breakable{
    for(x <- nums.indices){
      if(cumsum(x)-nums(x)==cumsum(nums.length-1)-cumsum(x)){
       pivotIndex=x
        innerloop.break()
      }
    }
    }
    pivotIndex
    }

  def pivotIndexRecursive(nums: Array[Int]):Int={
    @tailrec
    def acc(index:Int, leftSum:Int, rightSum:Int):Int={
      if (index==nums.length) -1
      if (leftSum==rightSum-nums(index)) index
      else acc(index+1, leftSum+nums(index), rightSum-nums(index))

    }
    acc(0,0,nums.sum)
  }
  val data= Array(-1,-1,0,0,-1,-1)
  println(pivotIndex(data))
}

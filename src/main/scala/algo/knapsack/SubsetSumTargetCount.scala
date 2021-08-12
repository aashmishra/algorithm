package algo.knapsack

object SubsetSumTargetCount extends App {

//  var count =0
  def countSubsetRecursive(nums:Array[Int], target:Int, sum:Int, index:Int, count:Int):Int={
    if(index==nums.length) return count
    if(nums(index)+sum>target) return countSubsetRecursive(nums, target, sum,index+1, count)
    val newCount = if(nums(index)+sum ==target) count+1 else count
    newCount +
      countSubsetRecursive(nums,target, sum+nums(index), index+1,count) +
      countSubsetRecursive(nums, target, sum,index+1,count)
  }


  def printMatrix(array: Array[Array[Int]]):Unit={
    println("")
  for(i<-array.indices){
    for(j<-array(0).indices){
      print(array(i)(j)+",")
    }
    println("")
  }
  }

  def countSubsetDP(nums:Array[Int], target:Int):Int={
    val countDP:Array[Array[Int]] = Array.ofDim(nums.length, target+1)
    for(i<-countDP.indices) countDP(i)(0)=1
    for(i<-0 until target+1) countDP(0)(i)= {if(nums(0)==i) 1 else 0}
    for(i<- 1 until countDP.length){
      for(j<-1 until target+1){
        if(nums(i)>j) countDP(i)(j)=countDP(i-1)(j)
        else {
          countDP(i)(j)= countDP(i-1)(j)+ countDP(i-1)(j-nums(i))
        }
      }
    }
   countDP(nums.length-1)(target)
  }


  val data = Array(1,2,3,3,3)
  val targetCount = 6
  println(countSubsetRecursive(data,6,0,0,0))
  println(countSubsetDP(data, 6))
}

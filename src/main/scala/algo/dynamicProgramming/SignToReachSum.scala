package algo.dynamicProgramming

object SignToReachSum extends App{

  def countSubset(array: Array[Int], target:Int):Int={
    val dpRow = array.length
    val dpColumn = target+1
    val dp: Array[Array[Int]]=Array.ofDim(dpRow,dpColumn)

    for(i<- 0 until dpRow)  { dp(i)(0)=1 }
    dp(0)(array(0))=1

    for(i<- 1 until dpRow; j<-1 until dpColumn){
      dp(i)(j)=  if(array(i)<= j){
        dp(i-1)(j-array(i)) + dp(i-1)(j)
      } else {
        dp(i-1)(j)
      }
    }
    dp(dpRow-1)(dpColumn-1)
  }

  def findTargetSumWays(nums: Array[Int], target: Int): Int = {
    val total = nums.sum
    if((total +  Math.abs(target))%2!=0){return 0}
    val getActualTarget = (total +   Math.abs(target))/2

    val res= countSubset(nums.sorted.reverse, getActualTarget)
    if(target==0 & nums.contains(0)){
      return Math.pow(2.0,nums.count(x=>x==0).toDouble).toInt
    }
    res
  }

  val data = Array(0,0,0,0,0,0,0,0,0)
  println(findTargetSumWays(data,0))

}

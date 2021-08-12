package algo.dynamicProgramming

object CountSubsetOfCount extends  App{

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

  val data = Array(1,1,1,1,1)
  println(countSubset(data,4))
}

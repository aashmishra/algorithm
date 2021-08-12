package algo.String

object LongestPalindrome extends App{

  def longestPalindrome(s: String): String = {
    val input  = s.toCharArray
    val dp:Array[Array[Int]]= Array.ofDim[Int](s.length,s.length)
    var maxi = 0
    var maxj = 0
    var max = -1
    for(i<-input.indices){
      dp(i)(i)=1
    }


    for(i<-0 until input.length-1){
      if(input(i)==input(i+1)) {dp(i)(i+1)=1; maxi=i; maxj=i+1 }
    }
    var j = -1
    for(k<- 3 to s.length){
      for(i<-0 to s.length-k) {
          j= i+k-1
        if(s(i)==s(j) && dp(i+1)(j-1)>0 ){
          dp(i)(j) = dp(i+1)(j-1) + 1
          if(dp(i)(j)>=max) {max = dp(i)(j); maxi=i; maxj=j}
        }
      }
    }



    for(i<- input.indices){
      println(dp(i).mkString(","))
    }
    s.slice(maxi,maxj+1)

  }


  val data  = "aaaabbaa"
  println(longestPalindrome(data))
}

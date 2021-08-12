package algo.array

import scala.util.control.Breaks

object Powerpair extends App {

  def getIndex(x: Array[Int], N: Int, element: Int):Int={
    var low=0
    var high=N-1
    var ans:Int = -1

    while(low<=high){
      val mid = (low+high)/2
      if(x(mid)>element){
        ans=mid
        high = mid-1
      }
      else{
        low=mid+1
      }
    }
    ans
  }

  // x[], y[]: input array elements
  // M, N: size of arrays x[] and y[] respectively
  //Function to count number of pairs such that x^y is greater than y^x.
  def countPairs(a: Array[Int], b: Array[Int], M: Int, N: Int): Int = {

    var zero = 0
    var one=0
    var two=0
    var three=0
    var four=0
    var ans:Int=0

    val x = a.sorted
    val y = b.sorted
     for(elm<-y){
       if(elm==0) zero+=1
       if(elm==1) one+=1
       if(elm==2) two+=1
       if(elm==3) three+=1
       if(elm==4) four+=1
     }

    val loop = new Breaks
    for(i<-x.indices){
        loop.breakable{
          if(x(i)==0){
            loop.break
          }
          else if (x(i)==1){
            ans+=zero
          }
          else if (x(i)==2){
            val index  = getIndex(y, N, 2)
            if(index != -1){
              ans += N-index
            }
            ans -=three
            ans -=four
            ans +=one+zero
          }
          else {
            val index  = getIndex(y, N, x(i))
            if(index != -1){
              ans += N-index
            }
            ans +=one+zero
            if(x(i)==3){
              ans+=two
            }
          }

        }
    }
    ans
  }


  val x = Array(1,2,6)
  val y = Array(1,5)
  val res = countPairs(x,y,3,2)
  print(res)
}
package algo.array

object TrappingRainWater extends App {

  def trap(height: Array[Int]): Int = {
    var leftMax = 0
    var rightMax = 0
    var lo = 0
    var hi = height.length-1
    var res = 0
    while(lo<=hi){
      if(height(lo)<height(hi)){
          if(height(lo)>leftMax){leftMax=height(lo)}
          else{res= res + leftMax-height(lo)}
        lo+=1
      } else {
        if(height(hi)>rightMax){rightMax=height(hi)}
        else{res= res + rightMax-height(hi)}
        hi-=1
      }
    }
    res
  }
  val arr = Array(0,1,0,2,1,0,1,3,2,1,2,1)
    println("total trapped is "+trap(arr));
}

package algo.array

object MinimumPlatform extends App{

  def merge(arr:Array[Int],l:Int,m:Int,r:Int): Unit ={
    val lLength = m-l+1
    val rLength=r-m

//    println("lLength "+lLength)
//    println("rLength "+rLength)


    val lTemp = new Array[Int](lLength)
    val rTemp = new Array[Int](rLength)

    for(i<-0 until lLength){ lTemp(i)=arr(l+i) }
    for(i<-0 until rLength){ rTemp(i)=arr(m+i+1) }

//    println(lTemp.mkString("(",",",")")+"-------"+rTemp.mkString("(",",",")"))

    var k=l
    var p=0
    var q=0

    while(p<lLength || q<rLength){
      if(q>=rLength || (p<lLength && {lTemp(p)<=rTemp(q)})){
        arr(k)=lTemp(p)
        p+=1
      } else {
        arr(k)=rTemp(q)
        q+=1
      }
      k+=1
    }
  }
  def sort(arr:Array[Int],l:Int, r:Int): Unit ={
    if(l<r){
      val mid = (r+l)/2
      sort(arr, l,mid)
      sort(arr, mid+1,r)
      merge(arr,l,mid,r)
    }
  }

  //Function to find the minimum number of platforms required at the
  //railway station such that no train waits.
  def findPlatform(arr: Array[Int], dep: Array[Int], n: Int): Int = {
    // add your code here
    sort(arr,0,n-1)
    sort(dep,0,n-1)
    var i:Int=1
    var j:Int=0
    var platformNeeded=1
    var maxPlatformNeeded=1

    while(i<n & j<n){
      if(arr(i)<=dep(j)){
        i+=1
        platformNeeded+=1
      } else {
        j+=1
        platformNeeded-=1
      }
      maxPlatformNeeded = Math.max(maxPlatformNeeded,platformNeeded)
    }
    maxPlatformNeeded
  }

//  val data = Array(6,5,4,3,2,1)
//  sort(data,0,5)
//  data.foreach(println(_))

  val arr = Array(900, 940, 950, 1100, 1500, 1800)
  val dep = Array(910, 1200, 1120, 1130, 1900, 2000)

  println(findPlatform(arr,dep,6))
}

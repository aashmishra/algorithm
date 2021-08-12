package algo.binarySelect

object FindFloorOrCeil extends App {

  def getFloorr(arr:Array[Int],search:Int):(Int,Int)={
    var len = arr.length-1
    var (start,end)=(0,len)
    var mid:Int=0
    var (floor,ceil) =(0,len)

    if(arr(len)<search) return (len,len)
    if(arr(0)>search) return (0,0)

    while(end>=start){
      mid = start + (end-start)/2
      if(arr(mid)==search) return (mid,mid)
      if(arr(mid)>search) {end=mid-1;ceil=mid;}
      else {start=mid+1; floor=mid; }
    }
    (floor,ceil)
  }

//  def searchInsertt(nums: Array[Int], target: Int): Int = {
//    getFloor(data,target) match {
//      case (f,_) if data(f)==target =>  f
//      case (f, _)=>  f+1
//    }
//  }



  def getFloor(arr:Array[Int],search:Int):Int={
    var len = arr.length-1
    var (start,end)=(0,len)
    var mid=0
    var place =0
    if(arr(len)<search) return len+1
    if(arr(0)>search) return 0
    while(end>=start){
      mid = start + (end-start)/2
      if(arr(mid)==search) return mid
      if(arr(mid)>search) end=mid-1
      else {start=mid+1; place=mid+1 }
    }
    place
  }
  def searchInsert(nums: Array[Int], target: Int): Int = {
    getFloor(nums,target)
  }
  val data = Array(1,3,5,6)
  println(searchInsert(data,2))

}
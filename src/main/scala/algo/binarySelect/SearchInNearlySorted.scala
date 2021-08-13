package algo.binarySelect

object SearchInNearlySorted extends App{


  def search(arr:Array[Int],target:Int):Int={
    var (start,end)=(1,arr.length-2)
    var mid =start+(end-start)/2

    if(arr(0)==target) return 0
    if(arr(arr.length-1)==target) return arr.length-1

    while(start<end){
      mid= start+ (end-start)/2
      if(arr(mid)==target) return mid
      if(arr(mid+1)==target) return mid+1
      if(arr(mid-1)==target) return mid-1
      if(arr(mid)>target) end=mid-2 else start=mid+2
    }
    -1
  }

  val data = Array(5,10,30,20,40,50,60,70,80,90)
 println(search(data,30))
}

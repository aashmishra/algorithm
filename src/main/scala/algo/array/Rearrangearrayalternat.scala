package algo.array

object Rearrangearrayalternat extends App{

  def rearrangearrayn(nums: Array[Int]): Array[Int] = {
    val rearrangedArray = new Array[Int](nums.length)
    var i=0
    var j=nums.length-1
    var k = 1
    while(i<=j){
      if(k%2==0) {rearrangedArray(k-1)=nums(i); i+=1} else {rearrangedArray(k-1)=nums(j); j-=1}
      k+=1
    }
    rearrangedArray
  }

  def rearrangearrayone(nums: Array[Int]): Array[Int] = {
    val m = nums(nums.length-1)+1
    var i=0
    var j=nums.length-1
    var k = 1
    while(i<=j){
      if(k%2!=0) {nums(k-1)=nums(k-1)+((nums(j)%m)*m); j-=1} else {nums(k-1)=nums(k-1)+((nums(i)%m)*m); i+=1}
      k+=1
    }
    nums.indices.foreach(index=> nums(index)=nums(index)/m)
    nums
  }

  val data = Array(1,2,3,4,5,6)
  val x  = rearrangearrayn(data)
  val y  = rearrangearrayone(data)
  println(x.mkString(","))
  println(y.mkString(","))

}

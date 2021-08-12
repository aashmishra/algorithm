package algo.array

object CountSmallerArray extends App {
  def merge(array: Array[Int],l:Int,m:Int,r:Int):List[Int]={

    var inverseCount = 0
    // size of both arrays to be merged
    val sizeOfL = m-l+1
    val sizeOfR = r-m

    println(s"size of x $sizeOfL and size of y $sizeOfR")

    val L = new Array[Int](sizeOfL)
    val R = new Array[Int](sizeOfR)

    //copy data in temp
    //    val L = array.slice(l,m)
    //    val R = array.slice(m+1,r)
    for(i <- 0 until sizeOfL)
    {
      L(i)=array(l+i)
    }
    println("Left subarray is:"+L.mkString("(",",",")"))


    for(j <- 0 until sizeOfR)
    {
      R(j)=array(m+j+1)
    }
    println("right subarray is:"+R.mkString("(",",",")"))

    var a=0
    var b=0

    // Initial index of merged subarry array
    var c=l

    while(a<sizeOfL & b<sizeOfR){
      if(L(a)<=R(b)){
        array(c)=L(a)
        a+=1

      }
      else{
        array(c)=R(b)
        b+=1
        inverseCount+=sizeOfL-a
      }
      c+=1
    }

    /* Copy remaining elements of L[] if any */
    while(a<sizeOfL){
      array(c)=L(a)
      a+=1
      c+=1
    }

    /* Copy remaining elements of R[] if any */
    while(b<sizeOfR){
      array(c)=R(b)
      b+=1
      c+=1
    }
    println(s"after merge suarray is "+array.slice(l,r+1).mkString("(",",",")")+" so return List("+inverseCount+")")
    List(inverseCount)
  }

  def mergeSort(data: Array[Int],l:Int,r:Int):List[Int]={
    var invCount = List.empty[Int]
    if(l<r){
      val middle = (l+r)/2
      invCount = List.concat(invCount,mergeSort(data, l,middle))
      invCount = List.concat(invCount,mergeSort(data, middle+1,r))
      invCount =  List.concat(invCount,merge(data,l,middle,r))
    }
    invCount
  }
  def countSmaller(nums: Array[Int]): List[Int] = {
   mergeSort(nums,0,nums.length-1)
  }

  val data = Array(5,2,6,1 )
  countSmaller(data).foreach(println(_))
}

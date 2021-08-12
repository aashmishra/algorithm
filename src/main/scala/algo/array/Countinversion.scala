package algo.array

import scala.annotation.tailrec

object Countinversion extends App{

  def merge(array: Array[Long],l:Int,m:Int,r:Int):Int={

    var inverseCount = 0
    // size of both arrays to be merged
    val sizeOfL = m-l+1
    val sizeOfR = r-m

    println(s"size of x $sizeOfL and size of y $sizeOfR")

    val L = new Array[Long](sizeOfL)
    val R = new Array[Long](sizeOfR)

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
    println(s"after merge suarray is "+array.slice(l,r+1).mkString("(",",",")"))
    inverseCount
  }

  def mergeSort(data: Array[Long],l:Int,r:Int):Int={
    var invCount =  0
    if(l<r){
        val middle = (l+r)/2
        invCount += mergeSort(data, l,middle)
        invCount += mergeSort(data, middle+1,r)
        invCount +=  merge(data,l,middle,r)
    }
    invCount
  }
  def inversionCount(arr: Array[Long], N: Long): Long = {
    // Your Code Here
    mergeSort(arr,0,N.toInt-1)
  }

  val data:Array[Long] = Array(2L, 4L, 1L, 3L, 5L)
  println("inverse count is = "+inversionCount(data,data.length))
  data.foreach(println(_))


}

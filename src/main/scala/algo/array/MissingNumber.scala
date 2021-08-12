package algo.array

object MissingNumber extends App{
    def missingNumber(nums: Array[Int]): Int = {
      //    println(s"max is $max")
      ((nums.length+1)*nums.length)/2 -nums.sum
    }


  val data = Array( 9,6,4,2,3,5,7,0,1)
  val data1 = Array( 0,1)
  println(missingNumber(data))
  println(missingNumber(data1))
}

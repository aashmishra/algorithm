package algo.array
import scala.util.control._

//1 2 3 4 8

object indexwithsumtotarget extends App {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val z = nums.zipWithIndex.sortBy(_._1)
    var x = new Array[Int](2)
    var s:Int=0
    val loop = new Breaks
    val innerLoop = new Breaks
    var b:Int =0
    loop.breakable
    {
      for(i <- z.indices)
      {
        s=target-z(i)._1
        innerLoop.breakable {
          for(j<-i+1 until nums.length)
          {
            if(z(j)._1==s)
            {
              x(0)=z(i)._2
              x(1)=z(j)._2
              loop.break
            }
          }
        }
      }
    }
    x
  }
  def twoSumHash(nums: Array[Int], target: Int): Array[Int] = {
    val dict = scala.collection.mutable.Map[Int, Int]()
    for {
      pair @ (x, i) <- nums.zipWithIndex
      if dict.contains(target - x) || {dict += pair; false}
      j <- dict.get(target-x)
    } return Array(j,i)
    throw new IllegalArgumentException("No two sum solution");
  }

  val data = Array(-1,-2,-3,-4,-5)
  val x  = twoSum(data, -8)
  x.foreach(println(_))
}

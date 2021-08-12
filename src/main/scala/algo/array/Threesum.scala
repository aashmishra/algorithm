package algo.array

import scala.collection.mutable

object Threesum extends App {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    var x= scala.collection.mutable.Set[Int]()
   val z: Seq[List[Int]] = for{
      i<- 0 until nums.length-1;x= scala.collection.mutable.Set[Int](); j <- i+1 until nums.length
      if x.contains(-(nums(i)+nums(j))) || {x.add(nums(j)); false}
       m<-List(List(nums(i),-(nums(i)+nums(j)),nums(j)).sorted)
    }  yield  m
    z.toList.distinct
//      z.map(x=>x.sortBy(y=>y)).distinct
  }

  val input:Array[Int] = Array()
  val output=threeSumd(input)
  output.foreach(println)


  def threeSumd(nums: Array[Int]): List[List[Int]] = {
      if (nums.length < 3) return List.empty[List[Int]]
      var lb = scala.collection.mutable.Set.empty[List[Int]]
      var hm = scala.collection.mutable.Map.empty[Int, Int]
      (0 to nums.length - 2).foreach { idx1 =>
        val num1 = nums(idx1)
        hm.getOrElseUpdate(num1, idx1)
        (idx1 + 1 to nums.length - 1).foreach { idx2 =>
          val num2 = nums(idx2)
          val target = 0 - num1 - num2
          hm.getOrElseUpdate(num2, idx2)

          if(hm.get(target).exists(t => t != idx1 && t != idx2)){
            lb += List(num1, num2, target).sorted
          }
        }
      }

      lb.toList
    }
}

package algo.array

import java.util.{ArrayList, Collections}
import java.util

object Choclate  extends  App{

  def findMinDiff(a: Array[Long], n: Long, m: Long) = {
    var min:Long = Integer.MAX_VALUE
    val ar = a.sorted
    for (i <- 0 to (n - m).toInt)
    {
      min = Math.min(min, ar(m.toInt + i - 1)  - ar(i.toInt))
    }
    min
    // your code here
  }
}

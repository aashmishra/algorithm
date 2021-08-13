package algo.stack

import scala.collection.immutable.Stack
import scala.collection.mutable

object StockSpannerScala extends App {

  class StockSpanner() {

    case class Pair(value: Int, index: Int)

    private var count = 0
    var s: scala.collection.mutable.Stack[Pair] = scala.collection.mutable.Stack[Pair]()

    def next(price: Int): Int = {
      while (s.nonEmpty && s.top.value <= price) s.pop
      val res = if (s.isEmpty) count + 1 else count - s.top.index
      s.push(Pair(price, count))
      this.count = count + 1
      res
    }
  }

  var S  = new StockSpanner()
  println(S.next(100))
  println(S.next(80))
  println(S.next(60))
  println(S.next(70))
  println(S.next(60))
  println(S.next(75))
  println(S.next(85))

//  var s = scala.collection.immutable.Stack[Pair]()
//  s.push(Pair(1,1))
//  s.push(Pair(2,2))

}

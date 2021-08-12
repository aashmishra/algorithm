package algo.dynamicProgramming
import scala.collection.immutable

object DecodeStringToAlphabet extends App{

  def numDecodings(s: String): Int = {
    val data: Map[String, Char] = (1 to 26).map(_.toString).zip('A' to 'Z').toMap
    val len=s.length
    val memoizeCache = scala.collection.mutable.HashMap.empty[Int, Int]
    def decode( i:Int):Int={
      if(memoizeCache.contains(i)) {return memoizeCache(i)} else {
      val result = {

      if(i== len) return 1
        if(i== len-1 && s(i)=='0') return 0
        if(i== len-1 && data.keySet.contains(s"${s(i)}") ) return 1
        if(len>=2){
        val first = s"${s(i)}"
        val second = s"${s(i)}${s(i+1)}"
        s match {
          case s if data.keySet.contains(first) && data.keySet.contains(second) => decode(i+1)+decode(i+2)
          case s if data.keySet.contains(first) => decode(i+1)
          case _ => 0
        }
      } else {0}
      }
        memoizeCache.put(i,result)
        result
      }
    }
    decode(0)
  }

  val s = "111111111111111111111111111111111111111111111"
  val i=0
  val first = s"${s(i)}"
  val second = s"${s(i)}${s(i+1)}"
//  println(second)
//  println(data.keySet.contains(first))
//  println(data.keySet.contains(second))
//  if (data.keySet.contains(first) && data.keySet.contains(second)) print("met")
  println(numDecodings(s))


}

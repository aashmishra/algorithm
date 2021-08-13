package algo.String

object PermutSubstring extends App{

  import scala.collection.mutable._

  def checkInclusion(s1: String, s2: String): Boolean = {
    val diffMap = HashMap.empty[Char, Int]
    s1.foreach(updateMap(diffMap, _, 1))

    println(diffMap)
    println(s2(2))

    (0 until s2.length).toList.exists(index => {
      if (index >= s1.length) updateMap(diffMap, s2(index - s1.length), 1)
      println("start")
      println(diffMap)
      println("end")
      updateMap(diffMap, s2(index), -1)
      println(diffMap)
      println("")
      println("")
      println("")
      println("")
      diffMap.isEmpty
    })


//    "eidbaooo"
  }

  def updateMap(map: HashMap[Char, Int], char: Char, incrementer: Int): Unit =
    map.get(char) match {
      case Some(number) if number + incrementer == 0 => map -= char
      case Some(number) => map += (char -> (number + incrementer))
      case None => map += (char -> incrementer)
    }

  def checkInclusionn(s1: String, s2: String): Boolean = s2.sliding(s1.length).exists(s1.sorted == _.sorted)


  val a =  "ab"
  val b =  "eidbaooo"
  println(checkInclusion(a,b))

}

package algo.String


import scala.collection.mutable.Stack

object RemoveDulicateInString extends App{

  def removed(input:List[Char],acc:List[Char], dup:Char):List[Char]={

    if(input.tail.isEmpty) return acc
    if(input.head == input.tail.head || input.head == dup){
      removed(input.tail.tail, acc,input.head)
    } else {

      removed(input.tail,acc :+ input.head,'0')
    }
  }

  def reiter(S:String, prevLength:Int):String={
    var repeat : Char = '0'
    val a = S.toCharArray.toList :+ '0'

    val finaldata = removed(a, List(), '0').mkString("").toString
//    println(finaldata)
    if(finaldata.length==prevLength)
      return finaldata
    else reiter(finaldata, finaldata.length)
  }

  def removeDuplicatesOld(S: String): String = {
    reiter(S,S.length)

  }

  def removeDuplicates(S: String): String = {

    if (S == null || S.length <= 1) return S
     var s = Stack[Char]()
    S.toCharArray.foreach( elem =>
     if(s.nonEmpty && s.top == elem ){
       s.pop
     } else {
       s.push(elem)
     })
    s.mkString("").reverse
  }

  val data = "acaaabbbacdddd"
  println(removeDuplicates(data))
}



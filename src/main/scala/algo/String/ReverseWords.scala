package algo.String

object ReverseWords extends App{

  def reverseWords(s: String): String = {
    s.split(" ").filterNot(_=="").reverse.mkString(" ")

  }

  def reverseWordss(s: String): String = {
    s.split(" ").map(word => word.trim).filter(_.length > 0).reverse.mkString(" ")
  }

  val data = "  Bob    Loves  Alice   "
  println(reverseWordss(data))
}

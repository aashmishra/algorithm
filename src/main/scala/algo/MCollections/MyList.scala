package algo.MCollections

import scala.util.Try

object MyList extends App{

  abstract class MyList[+A] {
    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyList[B]
    def printElements: String
    override def toString: String  = "[" + printElements + "]"

    def map[B](transformer: A=>B):MyList[B]
    def flatMap[B](transformer:A=> MyList[B]):MyList[B]
    def filter(predicate:A=>Boolean):MyList[A]

    def ++[B >:A](list:MyList[B]):MyList[B]
  }

  object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
    def printElements: String = ""

    override def map[B](transformer:Nothing=>B): MyList[B] = Empty
    override def flatMap[B](transformer: Nothing=>MyList[B]): MyList[B] = Empty
    override def filter(predicate: Nothing=>Boolean): MyList[Nothing] = Empty

    override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  }

  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head: A = h
    def tail: MyList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyList[B] = new Cons(element, this)
    def printElements:String = {
      if (t.isEmpty) "" + h
      else h + " " +t.printElements
    }

    def filter(predicate: A=>Boolean): MyList[A] = if(predicate(h)) new Cons(h, t.filter(predicate)) else t.filter(predicate)

    def map[B](transformer: A=> B): MyList[B] = new Cons(transformer(h), t.map(transformer))

    def ++[B >: A](list: MyList[B]): MyList[B] =  new Cons(h, t ++ list)

    def flatMap[B](transformer: A=> MyList[B]): MyList[B] = transformer(h) ++ t.flatMap(transformer)




  }
  val listInt: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listString: MyList[String] = new Cons("one", new Cons("two", new Cons("three", Empty)))
  println(listInt.head)
  println(listInt.add(4).head)
  println(listInt.toString)
  println(listString.toString)

  println(listInt.map(x=>x*2).toString)

  println(listInt.filter(x=> x%2==0).toString)

  println(listInt.flatMap(element=> new Cons(element, new Cons(element*2, Empty))).toString)

  implicit def intToString(x:Int):String=  x.toString

  def add( y:String):String={
    println("5 printted"+y)
    "5 "+y
  }

  add(4)


  implicit def stringtoInt(x:String):Int=  augmentString(x).toInt
//

  def addnew( y:Int):String={
    println(5+y)
    5+y
  }

  addnew("4")


}

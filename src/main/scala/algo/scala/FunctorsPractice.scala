package algo.scala

import scala.util.{Success, Try}

object FunctorsPractice {
    val anIncrementor = List(1,2,3).map(x => x+1) //List(2,3,4)

  //Options
  val anOption: Option[Int] = Some(2)

  //Try
  val aTry: Try[Int] = Success(42)

  val aTransformOption = anOption.map(x=>x*10)
  val aTransformedTry = aTry.map(x=>x*10)


  def do10xList(list:List[Int]):List[Int] = list.map(_*10)
  def do10xOption(option: Option[Int]):Option[Int] = option.map(_*10)
  def do10xTry(atry:Try[Int]):Try[Int] = atry.map(_*10)

  trait Functor[C[_]]{
    def map[A,B](container:C[A])(f:A=>B):C[B]
  }


//  given list Functor[List]{
//      override def map[A,B](container:List[A])(f:A=>B) = ???
//    }
//  }



}

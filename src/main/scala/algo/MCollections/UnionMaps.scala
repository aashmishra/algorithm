package algo.MCollections

import scala.collection.{LinearSeq, TraversableLike}
import scala.collection.generic.CanBuildFrom
import scala.language.higherKinds

object UnionMaps extends App{

//  class x extends scala.collection.mutable.Builder[Int]

  def flat(any: Any):List[Any]={
    any match {
      case i:List[_]=>i
      case _ =>List(any)
    }
  }

  def combineMapsOfIterables[K, V](a: Map[K, V], b: Map[K, V]): Map[K, V] = {
    (a.toSeq ++ b.toSeq).groupBy(_._1).mapValues(_.map(_._2).toList.flatten(flat)).asInstanceOf[Map[K,V]]
  }


  val data1 = Map(1->List("one"),2->List("two"),3->List("three"))
  val data2 = Map(1->List("ne"),2->List("wo"),3->List("hree"))
  println(combineMapsOfIterables(data1,data2))
}

package algo.MCollections

object Union extends App{



    def combineMapsOfIterabl[K,V](a: Map[K, V], b: Map[K, V]): Map[K, V] = {
      val union: Seq[(K, V)] = a.toSeq ++ b.toSeq
      val grouped: Map[K, Seq[(K, V)]] = union.groupBy(_._1)


       val finall: Map[K, Seq[V]] = grouped.mapValues(_.map(_._2))
        finall.asInstanceOf[Map[K,V]]
    }


    val data1 = Map(1->Seq("one"),2->Seq("two"),3->Seq("three"))
    val data2 = Map(1->Seq("ne"),2->Seq("wo"),3->Seq("hree"))
    println(combineMapsOfIterabl(data1,data2))
}

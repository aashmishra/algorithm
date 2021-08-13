package algo.array

object MergeTwoList extends App{

  def merge(l1:List[Int],l2:List[Int], res:List[Int]):List[Int]={
    if(l1.isEmpty) return res ::: l2
    if(l2.isEmpty) return res ::: l1
    if(l1.head>l2.head) merge(l1,l2.tail,res:+l2.head)
    else merge(l1.tail,l2,res:+l1.head)
  }

  val l1= List(-1,1,3,5,7,9)
  val l2= List(2,4,6,8,10)
  println(merge(l1,l2,List()))

}

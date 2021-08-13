package algo.array

object ListSubsEvent extends App{

  def binarySearch(list: List[String],start:Int,end:Int,search:String):Boolean={
    if(start>end) return false
    val random = new scala.util.Random
    val middle=start + random.nextInt( (end - start) + 1 )
    if(list(middle)==search) return true
    if(list(middle)>search){ binarySearch(list, start, middle-1,search)}
    else { binarySearch(list, middle+1, end,search)}
  }
  def search(listA: List[String],listB:List[String]):List[String]={
    listA.filter(binarySearch(listB,0,listB.length-1, _))
  }

  val evt1 = List("aman","ashis")
  val evt2 = List("a","aman","ashis", "x")
println("")

//  println("apple"=="appl")

}

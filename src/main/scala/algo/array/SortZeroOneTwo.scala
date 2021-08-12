package algo.array

object SortZeroOneTwo extends App {

  def sortColors(nums: Array[Int]): Unit = {
    val data = nums.foldLeft(Array(0,0,0)){(cnt,elem)=> cnt(elem)=cnt(elem)+1; cnt}
    val newData: Array[Int] = for{
      x <- Array(0,1,2)
      y<- 0 until data(x) if data(x)>0
      } yield x

      newData.foldLeft(0){(index,elm)=>nums(index)=elm ; index+1}
  }

  val data = Array(0,1,0,1)
  sortColors(data)
  data.foreach(println(_))
}

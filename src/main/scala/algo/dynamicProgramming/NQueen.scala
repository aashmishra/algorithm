package algo.dynamicProgramming

object NQueen extends App{

  def isSafe(row:Int,column:Int,positionFinal:List[Int]):Boolean={
    for(j<-0 until row){
      if(positionFinal(j)==column) {return false}
      if(Math.abs(column-positionFinal(j))==Math.abs(j-row)) return false
    }
     true
  }

  def show(queens: List[Int],n:Int): List[String] = {
    for (col <- queens) yield "." * col ++ "Q" ++ "." * (n - col - 1)
  }

  def nqueenSet(row:Int,n:Int,positionFinal:List[Int]):List[List[Int]]={
    if(row==n) {
      return   List(positionFinal)}
    (0 until n).foldLeft(List(List.empty[Int])) { (list, column) =>
      if (isSafe(row, column, positionFinal)) {
        list ::: nqueenSet(row + 1, n, positionFinal:+column)
      }
      else {
        list
      }
    }.filter(_.nonEmpty)
  }

  def solveNQueens(n: Int): List[List[String]] = {
      nqueenSet(0,n,List.empty[Int]).map(data=> show(data,n))
  }
  println(solveNQueens(4))
}

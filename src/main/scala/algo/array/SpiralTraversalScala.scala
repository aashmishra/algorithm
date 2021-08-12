package algo.array

import java.util
import java.util.ArrayList

object SpiralTraversalScala extends App{

  def spirallyTraverse(matrix: Array[Array[Int]]):List[Int] = { //        int total = r*c
      var ar = List.empty[Int]
      var startRow=0
      var startCol=0
    var row=matrix.length
    var col=matrix(0).length
      while(startRow<row & startCol<col){
        //print left to right
        for(i<- startCol until col){ ar= ar :+ matrix(startRow)(i)}
        startRow+=1
        
        //print top to bottom
        for(i<-startRow until row){
          ar= ar :+ matrix(i)(col-1)
        }
        col -= 1
        //print left to right
        if(startRow<row) {
          for (i <- col-1 to startCol by -1) {
            ar= ar :+matrix(row-1)(i)
          }
          row-=1
        }
        if(startCol<col) {
          for (i <- row-1 to startRow by -1) {
            ar= ar :+ matrix(i)(startCol)
          }
          startCol+=1
        }

      }
      ar

      }

  val data = Array(
    Array(1,2,3,4),
    Array(5,6,7,8),
    Array(9,10,11,12)
  )
  spirallyTraverse(data).foreach(println(_))
}

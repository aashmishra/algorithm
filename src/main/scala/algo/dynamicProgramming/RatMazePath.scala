package algo.dynamicProgramming
import scala.collection.immutable

object RatMazePath extends App{

def valid(data:Array[Array[Int]],sol:Array[Array[Int]],i:Int,j:Int):Boolean={
  if(i<0 || j<0 || i>=data.length || j>=data(0).length || data(i)(j)==0 || sol(i)(j)==1){
    false} else { true }
}

  def movePath(data:Array[Array[Int]], sol:Array[Array[Int]],i:Int, j:Int,path:String):List[String]={
    if(!valid(data,sol, i,j)) return List()
    if(data(i)(j)==9) { return List(path)}
    sol(i)(j)=1
    val a:List[String] =movePath(data, sol, i+1,j, path+"D")
    val b:List[String] =movePath(data, sol, i-1,j,path+"U")
    val c:List[String] =movePath(data, sol, i,j+1, path+"R")
    val d:List[String] =movePath(data, sol, i,j-1, path+"L")
    sol(i)(j)=0
    return a ++ b ++ c ++ d
  }


  val data  = Array(
    Array(1,1,1,1,1,1,1,1),
    Array(1,1,0,0,0,0,0,1),
    Array(1,0,0,0,0,0,0,1),
    Array(1,0,0,0,0,0,0,1),
    Array(1,0,0,0,0,0,0,1),
    Array(1,1,1,1,1,1,1,9)
  )

  val sol= Array.ofDim[Int](data.length, data(0).length)
  data.foreach{e=>e.foreach{x =>print("  "+x)}; println("")}
  movePath(data, sol,0,0,"").foreach(println(_))
  sol.foreach{e=>e.foreach{x =>print("  "+x)}; println("")}
}

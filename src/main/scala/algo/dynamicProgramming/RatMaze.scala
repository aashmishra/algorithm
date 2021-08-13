package algo.dynamicProgramming

object RatMaze extends App{

def valid(data:Array[Array[Int]],sol:Array[Array[Int]],i:Int,j:Int):Boolean={
  if(i<0 || j<0 || i>=data.length || j>=data(0).length || data(i)(j)==0 || sol(i)(j)==1){
    false} else { true }
}

  def movePath(data:Array[Array[Int]], sol:Array[Array[Int]],i:Int, j:Int):Boolean={
    if(!valid(data,sol, i,j)) return false
    if(data(i)(j)==9) return true
    sol(i)(j)=1
    if(movePath(data, sol, i+1,j)) return true
    if(movePath(data, sol, i-1,j)) return true
    if(movePath(data, sol, i,j+1)) return true
    if(movePath(data, sol, i,j-1)) return true
    sol(i)(j)=0
    return false
  }


  val data  = Array(
    Array(1,1,1,1,0,1,1,1),
    Array(1,1,0,1,0,1,0,1),
    Array(1,1,1,1,0,1,0,1),
    Array(1,1,0,1,0,1,0,1),
    Array(1,1,1,1,0,1,0,1),
    Array(1,1,0,1,1,1,0,9)
  )

  val sol= Array.ofDim[Int](data.length, data(0).length)
  data.foreach{e=>e.foreach{x =>print("  "+x)}; println("")}
 println(movePath(data, sol,0,0))
  sol.foreach{e=>e.foreach{x =>print("  "+x)}; println("")}
}

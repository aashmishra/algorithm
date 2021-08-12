package algo.tree

object CheckIdentical extends App{

  class TreeNode(_value:Int=0, _left:TreeNode=null, _right:TreeNode=null)
  {
    var value:Int=_value
    var left:TreeNode=_left
    var right:TreeNode=_right
  }
  def isIdentical(A:TreeNode, B:TreeNode):Boolean={
    if(A==null || B==null) { if (A==null && B==null) return true else return false}
    if(A.value!=B.value) return false
   isIdentical(A.left,B.left) && isIdentical(A.right, B.right)
  }


  val A = new TreeNode(1,new TreeNode(2),new TreeNode(3))
  val B= new TreeNode(1,new TreeNode(2))
  println(isIdentical(A,B))

}

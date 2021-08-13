package algo.tree

object DiameterOfTree extends App{

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
      var value: Int = _value
       var left: TreeNode = _left
       var right: TreeNode = _right
     }
  def getHeight(root: TreeNode, res:Int):Int={
    if(root==null ) return res-1
    val left = getHeight(root.left,res+1)
    val right = getHeight(root.right,res+1)
    Math.max(left,right)
  }
  // val info= scala.collection.mutable.Map.empty[TreeNode,Int]
  def diameterOfBinaryTree(root: TreeNode): Int = {
    // if(info.keySet.contains(root)) return info(root) else {
    if(root==null || (root.left==null && root.right==null) ) return 0
    val leftHeight = getHeight(root.left,1)
    val rightHeight = getHeight(root.right,1)
    val maxNodeHeightDiff =leftHeight+rightHeight
    println(s"height of left of ${root.value} -->" + leftHeight)
    println(s"height of rght of ${root.value} -->" + rightHeight)
    val maxDiameter= Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right))
    // println("maxDiameter-->"+Math.max(maxNodeHeightDiff, maxDiameter))
    Math.max(maxNodeHeightDiff, maxDiameter)
    // info ++ Map(root->r)

  }


}

package algo.tree

object DiameterOfTreeOrdN extends App{

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  /**
    * I created this so that each instance of test case must have a separate object
    * I tried to do it using var height but that was getting shared among test case (guessing :))
    * @param maxPathCount
    */
  case class Diameter(var maxPathCount:Int)

  /** Diameter of the tree in this question is the number of paths between edges
    * we are doing the work in O(n) time in this problem
    * We find the diameter in height function itself by using the pre-calculated left and right
    * @param root
    * @param d
    * @return
    */
  def getHeight(root: TreeNode, d: Diameter):Int={
    if(root==null ) return 0
    val left = if (root.left==null) 0 else getHeight(root.left,d)
//    println(s"height of Left of ${root.value} -->"+left)

    val right = if (root.right==null) 0 else getHeight(root.right,d)
//    println(s"height of Right of ${root.value} -->"+right)

    d.maxPathCount= Math.max(d.maxPathCount,left + right)
//    println("height->"+height)
    1+Math.max(left,right)
  }

  def diameterOfBinaryTree(root: TreeNode): Int = {
    val d = new Diameter(0)
    getHeight(root,d)
//    println(d.maxPathCount)
    d.maxPathCount
  }

  val treeNode = new TreeNode(1)
  treeNode.left=new TreeNode(2)
//  treeNode.right = new TreeNode(3)
//  treeNode.left.left=new TreeNode(4)
//  treeNode.left.right=new TreeNode(5)


  diameterOfBinaryTree(treeNode)



}

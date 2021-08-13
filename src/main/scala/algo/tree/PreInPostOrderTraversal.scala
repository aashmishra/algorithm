package algo.tree

object PreInPostOrderTraversal extends App{

  class TreeNode(_value:Int = 0, _left:TreeNode= null, _right:TreeNode = null){
    var value:Int = _value
    var left:TreeNode = _left
    var right:TreeNode = _right
  }


  def preOrder(root:TreeNode):Unit={
    if(root==null) return
    print(" "+root.value)
    preOrder(root.left)
    preOrder(root.right)
  }

  def inOrder(root:TreeNode):Unit={
    if(root==null) return
    inOrder(root.left)
    print(" "+root.value)
    inOrder(root.right)
  }

  def postOrder(root:TreeNode):Unit={
    if(root==null) return
    postOrder(root.left)
    postOrder(root.right)
    print(" "+root.value)
  }


  val root = new TreeNode(1,new TreeNode(2,new TreeNode(4 ),new TreeNode(5)),
  new TreeNode(3,new TreeNode(6 ),new TreeNode(7))
  )

  preOrder(root)
  println("")
  inOrder(root)
  println("")
  postOrder(root)
}

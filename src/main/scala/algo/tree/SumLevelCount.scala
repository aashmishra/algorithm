package algo.tree

import scala.util.Try

object SumLevelCount extends App{


  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def getCountLevel(root:TreeNode, level:Int):List[(Int,Int)]={
    if(root.left==null && root.right==null) return List.empty[(Int, Int)]
    List((level+1,root.left.value + root.right.value)) ::: getCountLevel(root.left,level+1) ::: getCountLevel(root.right,level+1)
  }

  def findMaxLevel(root:TreeNode, level:Int):Int= {
    print(getCountLevel(root, 0))
     val getSumEachLevelExceptRoot: Map[Int,Int] = getCountLevel(root, 0).filterNot(x =>x._1==null  ).foldLeft(Map.empty[Int, Int])((mp, value) =>
      if (mp.keySet.contains(value._1)) {
        mp ++ Map(value._1 -> (mp(value._1) + value._2))
      } else {
        mp ++ Map(value._1 -> value._2)
      }
    )
    val getSumEachLevelWithRoot = Map(0-> root.value) ++ getSumEachLevelExceptRoot
     getSumEachLevelWithRoot.foldLeft((0, 0))((max, cur) => if (cur._2 > max._2) cur else max)._1
  }


  val l41 = new TreeNode(1,new TreeNode(1),new TreeNode(1))
  val l42 = new TreeNode(1,new TreeNode(1),new TreeNode(1))
  val l43 = new TreeNode(1,new TreeNode(1),new TreeNode(1))
  val l44 = new TreeNode(1,new TreeNode(1),new TreeNode(1))
  val l45 = new TreeNode(1,new TreeNode(1),new TreeNode(1))
  val l46 = new TreeNode(1,new TreeNode(1),new TreeNode(1))
  val l47 = new TreeNode(1,new TreeNode(1),new TreeNode(1))
  val l48 = new TreeNode(1,new TreeNode(1),new TreeNode(1))


  val l31 = new TreeNode(1,l41,l42)
  val l32 = new TreeNode(1,l43,l44)
  val l33 = new TreeNode(1,l45,l46)
  val l34 = new TreeNode(25,l47,l48)

  val l21 = new TreeNode(1,l31,l32)
  val l22 = new TreeNode(1,l33,l34)

  val root = new TreeNode(1,l21,l22)
  val finall = findMaxLevel(root,0)

  print(finall)

}

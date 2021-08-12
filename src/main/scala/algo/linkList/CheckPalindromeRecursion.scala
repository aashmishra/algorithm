package algo.linkList

object CheckPalindromeRecursion extends App{

  case class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }
  def isPalindrome(head: ListNode): Boolean = {
    if (head == null || head.next == null) return true
    val (reversed, length) = reverseRec(head)
    val comparisonsRequired = Math.ceil(length / 2).toInt
    compareLists(head, reversed, comparisonsRequired)

  }

  def reverseRec(head: ListNode, reversed: ListNode = null, length: Int = 0): (ListNode , Int) = {
    head match {
      case null => (reversed, length)
      case link => reverseRec( link.next, ListNode(link.x, reversed), length + 1)
    }
  }

  def compareLists(listA: ListNode, listB: ListNode, comparisonsLeft: Int): Boolean = {
    if (comparisonsLeft == 0) true
    else if (listA.x != listB.x) false
    else compareLists(listA.next, listB.next, comparisonsLeft - 1)
  }
}

package algo.linkList

import scala.annotation.tailrec

object LinkedListCycle extends App {

   case class ListNode(var _x: Int = 0) {
       var next: ListNode = null
       var x: Int = _x
     }
  def hasCycleRecursion(head: ListNode): Boolean = {
    @tailrec
    def loop(fp:ListNode, sp:ListNode):Boolean={
      if(fp==sp) return true
      if(fp==null || fp.next==null) return false
      loop(fp.next.next,sp.next)
    }
    if(head==null && head.next==null) return false else loop(head.next,head)
  }

  def hasCycle(head: ListNode): Boolean = {
    if(head==null || head.next==null) return false
    var fp=head.next
    var sp=head

    while (fp!=null && fp.next!=null){

      if(sp.next==fp.next) return true
      sp=sp.next
      fp=fp.next.next
    }
    false
  }
}

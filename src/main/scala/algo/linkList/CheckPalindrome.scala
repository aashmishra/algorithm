package algo.linkList

//import com.clearspring.analytics.util.ListNode2
import java.util
import java.util.LinkedList
object CheckPalindrome extends App{

   case class ListNode(_x: Int = 0, _next: ListNode = null) {
       var next: ListNode = _next
       var x: Int = _x
     }

    def isPalindrome(head:ListNode ): Boolean = {
      var sp:ListNode=head
      var fp:ListNode=head
      var mid:ListNode=null

      while(fp!=null && fp.next!=null){
        fp=fp.next.next
        sp=sp.next
      }

      mid = if(fp!=null) sp else sp.next
      var next:ListNode=null
      var prev:ListNode=null
      while(mid!=null){
        next=mid.next
        mid.next=prev
        prev=mid
        mid=next
      }

      while (prev!=null){
        if(prev.x!=head.x) return false
      }
      return true
    }
}

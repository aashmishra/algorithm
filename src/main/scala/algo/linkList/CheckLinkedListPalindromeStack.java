package algo.linkList;
import java.util.Stack;

public class CheckLinkedListPalindromeStack {
    public boolean isPalindrome( ListNode head) {
        ListNode sp=head, fp=head, mid=null;
        while(fp!=null && fp.next!=null)
        {
            fp=fp.next.next;
            sp=sp.next;
        }

        //odd number in a list
        if(fp!=null){
            mid=sp.next;
        } else {
            mid=sp;
        }

        Stack<Integer> s = new Stack<Integer>();
        while (mid!=null) {
            s.push(mid.val);
            mid=mid.next;
        }

        while (!s.empty()){
            if(s.peek()!=head.val) return false;
            s.pop();
            head=head.next;
        }
        return true;
    }
}

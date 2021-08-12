package algo.linkList;

public class CheckLinkedListPalindrom {

//  public class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
    public static void main(String[] args) {
          ListNode src  = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4,new ListNode(5,null)))));
          ListNode res = reverseList(src);

          while(res.next!=null){
              System.out.println(res.val);
              res=res.next;
          }
        System.out.println(res.val);
    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null, next= null;
        while(head.next!=null){
            next=head.next;
            head.next=prev;
            prev = head;
            head=next;
        }
        head.next=prev;
     return head;
    }
    public static boolean isPalindrome( ListNode head) {
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

       ListNode prev=null, next=null;
       while(mid!=null){
           next=mid.next;
           mid.next=prev;
           prev=mid;
           mid=next;
       }

       while(prev!=null){
           if(prev.val!=head.val){
               return false;
           } else {
               prev=prev.next;
               head=head.next;
           }
       }
       return true;

    }
}

package algo.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUSingQueuePopCostly {

    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    /** Initialize your data structure here. */
    public StackUSingQueuePopCostly() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int elem=-1;
        while (!q1.isEmpty()){
            elem = q1.peek();
            q1.remove();
            if(!q1.isEmpty()){
                q2.add(elem);
            }
        }
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return elem;
    }

    /** Get the top element. */
    public int top() {
        int elem=-1;
        while (!q1.isEmpty()){
            elem = q1.peek();
            q1.remove();
            q2.add(elem);
        }
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return elem;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
     if(q1.isEmpty()) {return true;}
     else {return false;}
    }

    public static void main(String[] args) {

    }
}

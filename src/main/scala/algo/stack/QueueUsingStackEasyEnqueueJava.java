package algo.stack;

import java.util.Stack;

public class QueueUsingStackEasyEnqueueJava {


       Stack<Integer> s1 = new Stack<Integer>();
       Stack<Integer> s2 = new Stack<Integer>();
        /** Initialize your data structure here. */
        public QueueUsingStackEasyEnqueueJava() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s2.push(x);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
           return s1.pop();
        }

        /** Get the front element. */
        public int peek() {
            return s1.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty();
        }

}

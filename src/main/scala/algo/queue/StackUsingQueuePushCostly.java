package algo.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuePushCostly {
        // Two inbuilt queues
         Queue<Integer> q1 = new LinkedList<Integer>();
         Queue<Integer> q2 = new LinkedList<Integer>();

         int current_size=0;

         void push(int x){
            current_size++;

            q2.add(x);
            while(!q1.isEmpty()){
                q2.add(q1.peek());
                q1.remove();
            }

            // Swap the queues
            Queue<Integer> temp = q1;
            q1=q2;
            q2=temp;
        }

         void pop(){
            if(q1.isEmpty()) return;
            q1.remove();
            current_size--;
        }

         int top(){
            if(q1.isEmpty()) return -1;
            return q1.peek();
        }

         int size(){
            return current_size;
        }

    public static void main(String[] args)
    {
        StackUsingQueuePushCostly s = new StackUsingQueuePushCostly();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());
    }
}

package algo.array;

import scala.Int;

import java.util.ArrayList;

public class reverseInGroupJava {
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        for(int i=0;i<n;i+=k){
            int left = i;
            int right= Math.min(i+k-1,n-1);
            Integer temp;
            while(left<right){
                temp=arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right,temp);
                left++;
                right--;

            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<Integer>(5);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        reverseInGroupJava m = new reverseInGroupJava();
        m.reverseInGroups(l,5,3);
        for(int i=0;i<5;i++){
            System.out.println(l.get(i));
        }
    }
}

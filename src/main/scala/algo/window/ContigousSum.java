package algo.window;

import java.util.*;

public class ContigousSum {

    /**
     *  https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
     * Input:
     * N = 5, S = 12
     * A[] = {1,2,3,7,5}
     * Output: 2 4
     * Explanation: The sum of elements
     * from 2nd position to 4th position
     * is 12.
     * @param arr
     * @param n
     * @param s
     * @return
     */
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> data = new ArrayList<Integer>(2);
        data.add(-1);
        data.add(-1);
        // initialized everything with 0
        int sum=0;
        int start = 0;
        int end =0;
        while(end<n){
            System.out.println("("+start+", "+end+" )");
            //we need to run inner while for recursive hit for end and then start
            while(sum<s && end<n) {
                sum+=arr[end];
                end++;
            }
            while(sum>s && start<n){
                sum-=arr[start];
                start++;
                if(end<start){end=start;}
            }
            if(sum==s)
            {
                data.remove(0);
                data.remove(0);
                data.add(start+1);
                data.add(end);
                break;
            }
        }

        return data;
    }

    public static void main(String[] args) {
        int[] input  = new int[]{135 ,101 ,170 ,125 ,79 ,159 ,163 ,65 ,106 ,146 ,82 ,28 ,162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68 ,100, 36, 95 ,104 ,12 ,123 ,1341 };
        ArrayList<Integer> output = subarraySum(input,42,468);
        System.out.println(output);
    }

}

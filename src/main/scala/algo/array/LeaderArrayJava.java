package algo.array;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderArrayJava {

    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int max=-1;
        for(int i=n-1; i>=0;i--)
        {
            if(arr[i]>=max){
                max= arr[i];
                ar.add(arr[i]);
            }
        }
        Collections.reverse(ar);
        return ar;

    }
}

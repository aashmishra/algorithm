package algo.array;

import java.util.Arrays;
import java.util.Collections;

public class MinimumPlatformJava {

    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
       Arrays.sort(arr); 
       Arrays.sort(dep); 
        // add your code here

        int i=1;
        int j=0;
        int platformNeeded=1;
        int maxPlatformNeeded=1;

        while(i<n & j<n){
            if(arr[i]<=dep[j]){
                i+=1;
                platformNeeded+=1;
            } else {
                j+=1;
                platformNeeded-=1;
            }
            maxPlatformNeeded = Math.max(maxPlatformNeeded,platformNeeded);
        }
        return maxPlatformNeeded;

    }
}

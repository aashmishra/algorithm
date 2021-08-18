package algo.array;

public class kadansMaxSubArraySum {

    //https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

    int maxSubarraySum(int arr[], int n){

        // Your code here
        int max=arr[0];
        int lmax=arr[0];
        for(int i=1; i<n; i++){

            if(arr[i]>lmax+arr[i]){
                lmax=arr[i];
            } else
            {
                lmax += arr[i];
            }
            //System.out.println(lmax);
            if(lmax>max){
                max=lmax;
            }
        }
        return max;
    }

}

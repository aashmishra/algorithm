package algo.array;

public class LeftRight {

    public static int findElement(int arr[], int n){
        int[] r = new int[n];
        int maxi=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            maxi=Math.min(maxi,arr[i]);
            r[i]=maxi;
        }
        maxi=-1;
        for(int j=1;j<n-1;j++){
            maxi = Math.max(maxi,arr[j-1]);
            if((arr[j]>=maxi) & (arr[j]<=r[j+1])){
                return arr[j];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrr = {5, 6, 4, 1, 7, 12, 9, 1, 4, 1, 11, 5, 7, 1};
        System.out.println(findElement(arrr,14));
    }
}

package algo.array;

public class KthSmallestJava {

    public static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int randomPartition(int arr[], int l, int r)
    {
        int n = r-l+1;
        int pivot = (int)(Math.random()) * (n-1);
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }
    public static int partition(int[] arr, int l, int r){
        int i=l;
        int pivotElement=arr[r];
        int temp;
        for(int j =l;j<r;j++) {
            if (arr[j] <= pivotElement) {
                swap(arr, j, i);
                i++;
            }
        }
        swap(arr, r, i);
        //swap pivot
        return i;
    }
    public static int kthSmallest(int[] arr, int l, int r, int k){
        int pivot = randomPartition(arr,l,r);
        if(pivot-l==k-1){
            return arr[pivot];
        }
        if(pivot-l>k-1){
           return kthSmallest(arr,l,pivot-1,k);
        }
           return kthSmallest(arr,pivot+1,r,k-pivot+l-1);


    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println("output = " + kthSmallest(arr,0,5,3));

        for(int j=0;j<=4;j++){
            System.out.println(arr[j]);
        }

    }
}

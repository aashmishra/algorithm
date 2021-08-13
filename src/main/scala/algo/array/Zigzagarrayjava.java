package algo.array;

public class Zigzagarrayjava {

    void swap(int arr[], int i, int j){
        int temp=0;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    void zigZag(int arr[], int n) {
        // code here

        if(n>=2){
            if(arr[0]>arr[1]){
                swap(arr,0,1);
            }
        }
        int greater=0;
        int i=2;
        while(i<n ){

            if(greater==0){
                if(arr[i]>arr[i-1]){
                    swap(arr, i, i-1);
                }
                greater=1;
            } else {
                if(arr[i]<arr[i-1]){
                    swap(arr, i, i-1);
                }
                greater=0;
            }
            i++;
        }
    }


    public static void main(String[] args) {
        int[] ar= {1,4,3,2};
        Zigzagarrayjava m = new Zigzagarrayjava();
        for(int i=0;i<4;i++){
            System.out.print(", " + ar[i]);
        }
        System.out.println("");
        m.zigZag(ar,4);
        for(int i=0;i<4;i++){
            System.out.print(", " + ar[i]);
        }
    }
}

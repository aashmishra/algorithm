package algo.array;

public class RotateAnArrayByK {

    public static int gcd(int x, int y){
        if(y==0) return x;
        return gcd(y,x%y);
    }
    public static void leftRotate(int[] arr, int k){
        int rotateBy = arr.length%k;
        int gcd = gcd(arr.length, rotateBy);
        int temp;
        int pointer,tpointer;
        for(int i=0; i<gcd;i++){
            pointer=i;
            temp=arr[i];
            while(true){
                tpointer=pointer+k;
                if(tpointer>=arr.length){
                    tpointer=tpointer-arr.length;
                }
                if(tpointer==i){ break;}
                arr[pointer]=arr[tpointer];
                pointer=tpointer;
            }
            arr[pointer]=temp;
        }
    }
    public static void rightRotate(int[] arr, int k){
        int rotateBy = arr.length%k;
        int gcd = gcd(arr.length, rotateBy);
        int temp,init;
        int pointer,tpointer;
        for(int i=gcd; i>0;i--){
            pointer=(arr.length-1)/i;
            init=pointer;
            System.out.println(pointer);
            temp=arr[init];
            while(true){
                tpointer=pointer-k;
                if(tpointer<0){
                    tpointer=arr.length+tpointer;
                }
                if(tpointer==init){ break;}
                arr[pointer]=arr[tpointer];
                pointer=tpointer;
            }
            arr[pointer]=temp;
        }
    }
    public static void main(String[] args) {
            int[] x = {5,6,7,1,2,3,4};
            int[] y = {4,5,6,7,1,2,3};
            leftRotate(x,3);
            for(int j=0;j<x.length;j++){
                System.out.print(x[j]+", ");
            }
        System.out.println("");
        rightRotate(y,3);
        for(int j=0;j<y.length;j++){
            System.out.print(y[j]+", ");
        }
    }

}

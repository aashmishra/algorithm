package algo.array;

public class MergeTwoListJava {

    static  int[] merge(int[] x, int[] y){
        int k=0; int i= 0; int j = 0;
        int[] res = new int[x.length+y.length];
        while(i<x.length & j<y.length){
            if(x[i]>y[j])  {res[k]=y[j]; j++;} else {res[k]=x[i]; i++;}  k++;
        }
        while(i<x.length) {res[k]= x[i]; i++; k++;}
        while(j<y.length) {res[k]= y[j]; j++; k++;}
        return res;
    }
    public static void main(String[] args) {
        int[] l1= {-1,1,3,5,7,9};
        int[] l2= {2,4,6,8,10};
        int[] res= merge(l1,l2);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+",");
        }
    }
}

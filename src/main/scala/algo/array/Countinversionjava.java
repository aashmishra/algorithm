package algo.array;

import java.util.Arrays;

public class Countinversionjava {

    static int merge(long array[],int l,int m,int r){

        int inverseCount = 0;
        // size of both arrays to be merged
        int sizeOfL = m-l+1;
        int sizeOfR = r-m;

//        System.out.println("size of x" +sizeOfL+" and size of y "+sizeOfR);

        long[] L = new long[sizeOfL];
        long[] R = new long[sizeOfR];

        //copy data in temp
//    int L = array.slice(l,m)
//    int R = array.slice(m+1,r)
        for(int i=0 ;i< sizeOfL;i++)
        {
            L[i]=array[l+i];
        }
//        System.out.println("Left subarray is:"+ String.join(",",Arrays.toString(L)));


        for(int j=0 ;j< sizeOfR;j++)
        {
            R[j]=array[m+j+1];
        }
//        System.out.println("Right subarray is:"+ String.join(",",Arrays.toString(R)));

        int a=0;
        int b=0;

        // Initial index of merged subarry array
        int c=l;

        while(a<sizeOfL & b<sizeOfR){
            if(L[a]<=R[b]){
                array[c]=L[a];
                a+=1;

            }
            else{
                array[c]=R[b];
                b+=1;
                inverseCount+=sizeOfL-a;
            }
            c+=1;
        }

        /* Copy remaining elements of L[] if any */
        while(a<sizeOfL){
            array[c]=L[a];
            a+=1;
            c+=1;
        }

        /* Copy remaining elements of R[] if any */
        while(b<sizeOfR){
            array[c]=R[b];
            b+=1;
            c+=1;
        }

       return inverseCount;
    }

    static int mergeSort( long[] data,int l,int r){
        int invCount =  0;
        if(l<r){
            int middle = (l+r)/2;
            invCount += mergeSort(data, l,middle);
            invCount += mergeSort(data, middle+1,r);
            invCount +=  merge(data,l,middle,r);
        }
        return invCount;
    }

    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long[] arr, long N)
    {
        // Your Code Here
        return mergeSort(arr,0,(int) (N-1));
    }
    public static void main(String [] args){
        long[] l = { 83, 20, 9, 50, 115, 61, 17 };

        System.out.println(inversionCount(l,7));
    }
}

package algo.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort012 {

    public static void sort012(int a[], int n)
    {
        int[] cnt = {0,0,0};
        for(int i=0; i<n;i++){
            cnt[a[i]]++;
        }
        int j=0;
        int k=0;
        while(j<n & k<3){
            if(cnt[k]>0){
                a[j]=k;
                cnt[k]-=1;
                j++;
            }
            else{
                k++;
            }

        }
    }

    public static void main(String ars[]){
        int[] data = {0,1,2,0,1};
        sort012(data,5);
        for(int k =0; k<5;k++){
            System.out.println(data[k]);
        }

    }
}

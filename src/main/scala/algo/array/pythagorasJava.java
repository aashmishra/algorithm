package algo.array;

import java.util.HashMap;

public class pythagorasJava {

    boolean checkTriplet(int[] arr, int n) {
        // code here
        int maximum=0;


        for(int i=0;i<n;i++){
            maximum=Math.max(maximum, arr[i]);
        }

        int[] map = new int[maximum+1];

        for(int j=0; j<n;j++){
            map[arr[j]]++;
        }

        for(int k=0; k<maximum+1; k++){
            if(map[k]==0){
                continue;
            }
            for(int l=1; l<maximum+1;l++){
                if((k==l & map[l]==1) || map[l]==0){
                    continue;
                }

                int sqroot = (int) Math.sqrt(k*k+l*l);

                if(sqroot*sqroot !=(k*k+l*l)){
                    continue;
                }

                if(sqroot>maximum){
                    continue;
                }

                if(map[sqroot] >=1){
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] r = {3, 2, 4, 6, 5};
        pythagorasJava k = new pythagorasJava();
        System.out.println(k.checkTriplet(r,5));
    }
}

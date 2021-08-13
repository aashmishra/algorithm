package algo.array;

public class EquilbriumPoint {
    public static int equilibriumPoint(long nums[], int n) {
        int pivotIndex = -1;
        long cum=0;

        if(nums.length==1){
            pivotIndex= 1;
            return 1;
        } else if (nums.length==2){
            return -1;
        }


        long[] cumsum = new long[nums.length];
//        val cumsum = new Array[Int](nums.length) scala
        for(int x=0;x<nums.length;x++){
            cum+=nums[x];
            cumsum[x]=cum;
        }

        for(int x=0;x<nums.length;x++){
            if(cumsum[x]-nums[x]==cumsum[nums.length-1]-cumsum[x]){
                pivotIndex=x+1;
                break;
            }
        }

        return pivotIndex;
    }
}

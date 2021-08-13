package algo.array;

public class TrappingRainWaterr {
    static int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int lo = 0;
        int hi = height.length-1;
        int res = 0;
        while(lo<=hi){
            if(height[lo]<height[hi]){
                if(height[lo]>leftMax){leftMax=height[lo];}
                else{res= res + leftMax-height[lo];}
                lo+=1;
            } else {
                if(height[hi]>rightMax){rightMax=height[hi];}
                else{res= res + rightMax-height[hi];}
                hi-=1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("total trapped is "+trap(arr));
    }


}

class Solution {
    private static  int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private static int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
//        System.out.println("mid is->"+mid);
        int left = majorityElementRec(nums, lo, mid);
//        System.out.println("left is->"+left);
        int right = majorityElementRec(nums, mid+1, hi);
//        System.out.println("right is->"+right);
        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
//        System.out.println("leftCount of "+left+" -> "+leftCount);
        int rightCount = countInRange(nums, right, lo, hi);
//        System.out.println("rightCount of "+right+" -> "+rightCount);
        int x =leftCount > rightCount ? left : right;
//        System.out.println("returning --->---->"+x);
        return x;
    }

    public static int majorityElement(int[] nums) {
        int y =  majorityElementRec(nums, 0, nums.length-1);
        if(countInRange(nums, y, 0, nums.length-1)>=nums.length/2){
            return 1;
        }
        else{
            return 0;
        }
    }
    public  static void  main(String [] args){
        int [] x = {1,2,1,2,1,3,4,2,2,2,2};
        System.out.println(majorityElement(x));

    }
}
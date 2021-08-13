package algo.knapsack;

public class KnapSackWeightValueBag {

    private static int maxi = 0;

    //Function to return max value that can be put in knapsack of capacity W.

    /**
     * Fill a value in a bag in such a way that weight is not more than capacity of the bag and
     * value is maximum as per value of weight after filling the bag
     * @param W Bag maximum capacity
     * @param wt weight array
     * @param val value array
     * @param n Number of element in weight and value array
     * @return Int maximum value that can be achieved under limit of bag weight
     */
    private static int knapSackRecursive(int W, int wt[], int val[], int n) {
        if (W == 0 || n == 0) return 0;
        if (wt[n - 1] > W) {
            return knapSackRecursive(W, wt, val, n - 1);
        }
        int include = val[n - 1] + knapSackRecursive(W - wt[n - 1], wt, val, n - 1);
        int exclude = knapSackRecursive(W, wt, val, n - 1);
        return Math.max(include, exclude);
    }
    private static int knapSackR(int W, int wt[], int val[], int n, int[][] max) {
        if (W == 0 || n == 0) return 0;
        if (max[n][W] > -1) return max[n][W];
        if (wt[n - 1] > W) {
            max[n][W] = knapSackR(W, wt, val, n - 1, max);
            return max[n][W];
        }
        int include = val[n - 1] + knapSackR(W - wt[n - 1], wt, val, n - 1, max);
        int exclude = knapSackR(W, wt, val, n - 1, max);
        max[n][W] = Math.max(include, exclude);
        return max[n][W];
    }
    private static int knapSackMemoize(int W, int wt[], int val[], int n) {
        int[][] max = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                max[i][j] = -1;
            }
        }

        return knapSackR(W, wt, val, n, max);
    }
    private static int knapSackTopDown(int W, int wt[], int val[], int n) {
        int[][] maxValue = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            maxValue[i][0] = 0;
        }
        for (int j = 0; j < W + 1; j++) {
            if (wt[0] < j) maxValue[0][j] = val[0];
            else maxValue[0][j] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    maxValue[i][j] = Math.max(val[i] + maxValue[i - 1][j - wt[i]], maxValue[i - 1][j]);
                }
            }
        }
        return maxValue[n - 1][W];
    }


    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] weight = {4, 5, 1};
        int n = 3;
        int bagSize = 4;
        System.out.println(knapSackRecursive(bagSize, weight, val, n));
        System.out.println(knapSackMemoize(bagSize, weight, val, n));
        System.out.println(knapSackTopDown(bagSize, weight, val, n));
    }

}

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0;
        Arrays.sort(w);
        int[][] data =  new int[w.length][W+1];
        for(int i=0; i<w.length;i++){
            data[i][0]=0;
        }
        for(int j=1; j<W+1;j++){
            if(w[0]<=j) {
                data[0][j] = w[0];
            }
            else{
                data[0][j] = 0;
            }
        }
        for(int i=1; i<w.length;i++)
        {
            for(int j=1; j<W+1;j++){
                if(w[i]>j){
                    data[i][j]=data[i-1][j];
                }
                else{
                data[i][j]=Math.max(w[i]+data[i-1][j-w[i]],data[i-1][j]);
            }
            }
        }
//        for(int i=0; i<w.length;i++)
//        {System.out.println("");
//            for(int j=0; j<W+1;j++) {
//                System.out.print(data[i][j]+",");
//            }
//        }

        return data[w.length-1][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
//        W = 20;
        n = scanner.nextInt();
//        n = 4;
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
//        int[]  w = {5,7,12,18};
        System.out.println(optimalWeight(W, w));
    }
}


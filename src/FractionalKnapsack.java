import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class FractionalKnapsack {
    private static double getOptimalValue(double capacity,  double[][] array, int n) {
        double value = 0;
        int currentIndex=0;
        int currentValueIndex;
        double total=0;
        //write your code here
        while(capacity>0 && currentIndex<n){
            if(array[currentIndex][1]<=capacity  ){
                total = total + array[currentIndex][0];
                capacity = capacity-array[currentIndex][1];
            }
            else{
                total = total + capacity*array[currentIndex][2];
                capacity = 0;
            }
            currentIndex++;

        }

        return Math.round (total * 10000.0) / 10000.0;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double capacity = scanner.nextDouble();
        double[][] array = new double[n][3];
//        int[] values = new int[n];
//        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
//            values[i] = scanner.nextInt();
//            weights[i] = scanner.nextInt();
            array[i][0]= scanner.nextDouble();
            array[i][1]=scanner.nextDouble();
            array[i][2]=array[i][0]/ array[i][1];


        }

        java.util.Arrays.sort(array, new java.util.Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[2], b[2]);
            }
        }.reversed());
//        for (int i = 0; i < n; i++) {
//        System.out.println(array[i][0]+ " " + array[i][1]+ " " +array[i][2]+ " ");
//    }
//        double[] x = new double[n];
//        for(int i=0 ;i<=n; i++){
//            x[i] = (double)values[i]/weights[i];
//        }
//        Arrays.sort(x);

        System.out.println(getOptimalValue(capacity, array, n));
    }
} 

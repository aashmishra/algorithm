package algo.array;

import java.util.ArrayList;

public class StockBuySellJava {

    static ArrayList<ArrayList<Integer>> stockBuySell(int prices[], int n) {
//    static void stockBuySell(int prices[], int n) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        int min = Integer.MAX_VALUE;
        int i=1;
            int minIndex = 0;
            int maxDiff = 0;
//            int maxIndex = 0;
//            int prevMinIndex=0;
            int[] minArray= new int[n];

            while( i <=n-1) {
                if(prices[i]>prices[minIndex] & prices[i]>prices[i-1]){
                    minArray[i]= minIndex;
                }else {
                    minIndex=i;
                    minArray[i]= i;
                }
                i++;
            }
        for(int k=0;k<=n-1;k++){
            if(prices[k]>prices[minArray[k]]){
                maxDiff=prices[k]-prices[minArray[k]];
            } else if(maxDiff>0){
                ArrayList<Integer> x = new ArrayList<Integer>(2);
                x.add(minArray[k-1]);
                x.add(k-1);
                result.add(x);
            }
        }
        if(prices[n-1]>prices[n-2]){
            ArrayList<Integer> y = new ArrayList<Integer>(2);
            y.add(minArray[n-1]);
            y.add(n-1);
            result.add(y);
        }

//        for(int k=0;k<=n-1;k++){
//            System.out.print("," + prices[k]);
//        }
//        System.out.println("");
//
//            for(int k=0;k<=n-1;k++){
//                System.out.print("," + prices[minArray[k]]);
//            }
//            return  new ArrayList{}{minIndex, maxIndex});
        return result;
    }


    public static void main(String[] args) {

        int[] k= {100,180,260,310,40,535,695};
        stockBuySell(k, 7).forEach(data->
                data.forEach(
                        ele-> System.out.println("ele = " + ele)
                )
    );
    }
}

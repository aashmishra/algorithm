import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class MaxPairwiseProductold {
    static BigInteger getMaxPairwiseProduct(int[] numbers) {
        BigInteger max_product = BigInteger.ZERO;
        int n = numbers.length;
        if(n<2){
            throw new IllegalArgumentException("Failed");
        }


//        for (int first = 0; first < n; ++first) {
//            for (int second = first + 1; second < n; ++second) {
//                 if(max_product.compareTo(
//                        BigInteger.valueOf(numbers[first]).multiply(BigInteger.valueOf(numbers[second]))) >0){
//                     max_product =BigInteger.valueOf(numbers[first]).multiply(BigInteger.valueOf(numbers[second]));
//                 }
//            }
//        }
        int first = 0;
        int second= 0;
        for (int i=0; i<n; i++)
        {
            if(numbers[i]>=(numbers[first]))
                {
                    second=first;
                    first=i;
                 }
            if(((numbers[i]>numbers[second]) && (i!=first)) || (second==first)){
                second=i;
            }
            }
        max_product=BigInteger.valueOf(numbers[first]).multiply(BigInteger.valueOf(numbers[second]));


        return max_product;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}

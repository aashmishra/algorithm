import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class MaxPairwiseProduct {
    public static void main(String[] args) {
        FastScanner s = new FastScanner(System.in);
        ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
        int n = s.nextInt();
        for(int i = 0; i<n; i++) {
            numbers.add(s.nextBigInt());
        }
        Collections.sort(numbers);
        BigInteger last = numbers.get(n-1);
        BigInteger secondLast = numbers.get(n-2);
        System.out.println(last.multiply(secondLast));
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
        BigInteger nextBigInt() {
            return BigInteger.valueOf(Integer.parseInt(next()));
        }
    }
}

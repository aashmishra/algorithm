import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x, int start, int end) {
        int left = 0, right = a.length;
        //write your code here
        if (end >= start) {


            int middle = (start + (end)) / 2;
//            System.out.println("start is "+start+" end is "+end);
//            System.out.println("middle is "+middle);
            if (x == a[middle]) {
                return middle;
            } else if (x > a[middle]) {
                return binarySearch(a, x, middle + 1, end);
            } else {
                return binarySearch(a, x, 0, middle - 1);
            }
        } else {
            return -1;
        }
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
//        int n = 5;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
//        int[] a  = {1,5,8,12,13};
        int m = scanner.nextInt();
//        int m = 5;
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
//        int[] b  = {8, 1, 23, 1, 11};
////        int[] b  = {23};
        int start = 0;
        int end = n-1;
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i], start, end) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

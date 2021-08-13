import java.math.BigInteger;
import java.util.*;

public class DotProduct {
    private static BigInteger maxDotProduct(BigInteger[] a, BigInteger[] b) {
        //write your code here
        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < a.length; i++) {
            result = result.add(a[i].multiply( b[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger[] a = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextBigInteger();
        }
        BigInteger[] b = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextBigInteger();
        }
        System.out.println(maxDotProduct(a, b));
    }
}


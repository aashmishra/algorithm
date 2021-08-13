import java.math.BigInteger;
import java.util.*;


public class LCM {

  private static int gcd_fast(int a, int b) {
    int current_gcd = 1;
    if(a%b==0)
    {
      return b;
    }

    return gcd_fast(b,a%b);
  }

  private static BigInteger lcm_fast(int a, int b) {

    BigInteger f = BigInteger.valueOf(a);
    BigInteger s = BigInteger.valueOf(b);
    return f.multiply(s).divide(BigInteger.valueOf(gcd_fast(a,b)));
//    if (a > b) {
//      return (a / gcd_fast(a, b)) * b;
//    } else {
//      return (b / gcd_fast(b, a)) * a;
//    }
  }
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
//    System.out.println(lcm_naive(a, b));
    System.out.println(lcm_fast(a, b));
  }
}

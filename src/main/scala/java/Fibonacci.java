import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {
  private static BigInteger calc_fib(int n) {
    if (n <= 1)
      return BigInteger.valueOf(n);

    ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
    numbers.add(BigInteger.ONE);
    numbers.add(BigInteger.ONE);
    
    for(int i = 2; i<n; i++) {
      numbers.add(numbers.get(i-1).add(numbers.get(i-2)));
    }
    return numbers.get(n-1);
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}

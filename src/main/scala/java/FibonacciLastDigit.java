import java.math.BigInteger;
import java.util.*;

public class FibonacciLastDigit {
        private static int getFibonacciLastDigitNaive(int n) {
            if (n <= 1)
                return n;

            int [] numbers = new int[n];
            numbers[0]=1;
            numbers[1]=1;
            for(int i = 2; i<n; i++) {
                numbers[i] = (numbers[i-1]+numbers[i-2])%10;
            }

            return numbers[n-1];
        }

    private static BigInteger getFibonacciLastDigitNaiveold(int n) {
        if (n <= 1)
            return BigInteger.valueOf(n);

        ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
        numbers.add(BigInteger.ONE);
        numbers.add(BigInteger.ONE);
        for(int i = 2; i<n; i++) {
            numbers.add(numbers.get(i-1).add(numbers.get(i-2)).mod(BigInteger.TEN));
        }

        return numbers.get(n-1);
    }

    private static int getFibonacciLastDigitNaiveOld(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        BigInteger c = getFibonacciLastDigitNaive(n);
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);

//        System.out.println("one");
//        int d = getFibonacciLastDigitNaiveOld(n);
//        System.out.println(d);
//        System.out.println("two");
//        System.out.println(calc_fib(n));
    }
}


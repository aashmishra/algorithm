import java.math.BigInteger;
import java.util.*;

public class FibonacciSumSquares {
    private static BigInteger orig_func(int n) {
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

    private static BigInteger calc_fib(long n ) {
        BigInteger m = BigInteger.TEN;
        if (n <= 1)
            return BigInteger.valueOf(n);
        if(m.equals(1))
            return BigInteger.ONE;
        if(m.equals(0))
            throw new IllegalArgumentException("Failed");

        ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
        BigInteger first =  BigInteger.ONE;
        BigInteger second =  BigInteger.ONE;
        BigInteger current;
        BigInteger firstM ;
//        BigInteger secondM ;
        BigInteger currentM ;
        int counter = 3;
        for(long i = 3; i<=n; i++) {
            current = first.add(second);
            first = second;
            second = current;
            currentM = current.mod(m);
            firstM = first.mod(m);
//            System.out.println("firstM->"+firstM.toString() +"currentM->"+currentM.toString() + "counter->" + Integer.toString(counter));
            if(firstM.equals(BigInteger.ZERO) && currentM.equals(BigInteger.ONE))
            {
                counter = counter-1;
                break;
            }
            counter = counter+1;

        }
//        System.out.println(counter);
//        System.out.println(n%counter);
        Long theLong  = n%counter;
        Integer i = (int) (long) theLong;
//        System.out.println(theLong);
//        System.out.println(counter);
//        System.out.println(orig_func(i));
//        System.out.println(orig_func(i).mod(m));
//        if(i<=3){
//            return (orig_func(i+1).multiply(orig_func(i)));}
//        System.out.println((orig_func(i+1).multiply(orig_func(i))));
//        System.out.println((orig_func(i+1)));
//        System.out.println(orig_func(i));
        return (orig_func(i+1).multiply(orig_func(i))).mod(BigInteger.TEN);

    }

    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        BigInteger s = calc_fib(n);
        System.out.println(s);
    }
}


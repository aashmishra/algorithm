import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int five=0;
        int one=0;
        int ten=0;
        //write your code here
        ten = m/10;
        m=m-ten*10;
//        System.out.println(m);
        five = m/5;
        m= m-five*5;
        one = m;
//        System.out.println("ten = "+ ten);
//        System.out.println("five = "+ five);
//        System.out.println("one = "+ one);
        return one+five+ten;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


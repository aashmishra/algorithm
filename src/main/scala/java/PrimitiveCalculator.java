import javax.sound.midi.Sequence;
import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
    private static List<Integer> optimal_sequences(int n) {
        int[] x = new int[n+1];
        List<Integer> sequence = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            if(i==1 || i==2 || i==3){ x[i]=1;sequence.add(1);}
            else if (i % 3 == 0 && i % 2 == 0 && Math.min(x[i/3],x[i/2])<x[i-1]) {
                x[i]=Math.min(x[i/3],x[i/2])+1;
                if(x[i/3]<x[i/2]){
//                    System.out.println("i % 3 == 0");
                    sequence.add(i/3);
                    x[i]= x[i/3]+1;
                } else{
//                    System.out.println("i % 2 == 0");
                    sequence.add(i/2);
                    x[i]=x[i/2]+1;
                }
//                System.out.println("u did "+(x[i]-1));

            } else if (i % 3 == 0 && x[i/3]<x[i-1]) {
//                System.out.println("i % 3 == 0");
                sequence.add(i/3);
                x[i]=x[i/3]+1;

            } else if (i % 2 == 0 && x[i/2]<x[i-1]) {
//                System.out.println("i % 2 == 0");
                sequence.add(i/2);
                x[i]=x[i/2]+1;
            } else {
//                System.out.println("x[i]=x[i-1]+1");
                sequence.add(i-1);
                x[i]=x[i-1]+1;
            }
        }
//        System.out.println("");
//        for(int i=0;i<=n;i++){
//            System.out.print(x[i]+",");
//        }
//        System.out.println("");
//        System.out.println("here is my data start");

        int index=n-1;
//        int j=0;

        while(index!=0){
//            System.out.print(sequence.get(index)+",");
            res.add(sequence.get(index));
//            j++;

        index = sequence.get(index)-1;
        }
//        for (Integer p : sequence) {
//            System.out.print(p + " ");
//        }
//        System.out.println("");
//        System.out.println("here is my data end");


//
//        System.out.println(sequence.get(10));
//        System.out.println(sequence.get(9));
//        System.out.println(sequence.get(8));
//        System.out.println(sequence.get(7));
//        System.out.println(sequence.get(6));
//        System.out.println(sequence.get(5));
//        System.out.println(sequence.get(4));
//        System.out.println(sequence.get(3));
//        System.out.println(sequence.get(2));
//        System.out.println(sequence.get(1));
//        System.out.println(sequence.get(0));
//        System.out.println("");
        Collections.reverse(res);
        res.add(n);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int n=5;
        List<Integer> sequence = optimal_sequences(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }

    }
}


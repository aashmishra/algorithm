import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.concurrent.ThreadLocalRandom;

public class Partition3 {

    static void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    private static int[] intersect(int[] a,int[] b) {
//        System.out.println(a.length +"  a and b  "+b.length);
        int[] c =a.clone();
        int k = 0;
        for (int i=0;i<b.length;i++){
            for (int j=0;j<a.length;j++){
                if(b[i]==a[j] && c[j]!=0){
                    c[j]=0;
                    break;
                }
            }
        }
        int[] p = Arrays.stream(c).filter(num -> num != 0).toArray();
//        for (int j=0;j<a.length;j++){
//            System.out.println("set data is a "+a[j]);
//        }
//        for (int j=0;j<b.length;j++){
//            System.out.println("set data is b "+b[j]);
//        }
//        for (int j=0;j<p.length;j++){
//            System.out.println("set data is c "+p[j]);
//        }
        return p;
    }
    private static int[] findPair(int[] w,int W) {
//        Arrays.sort(w);
        shuffleArray(w);
        int[][] data =  new int[w.length][W+1];
        for(int i=0; i<w.length;i++){
            data[i][0]=0;
        }
        for(int j=1; j<W+1;j++){
            if(w[0]<=j) {
                data[0][j] = w[0];
            }
            else{
                data[0][j] = 0;
            }
        }
        for(int i=1; i<w.length;i++)
        {
            for(int j=1; j<W+1;j++){
                if(w[i]>j){
                    data[i][j]=data[i-1][j];
                }
                else{
                    data[i][j]=Math.max(w[i]+data[i-1][j-w[i]],data[i-1][j]);
                }
            }
        }

//        for(int i=0; i<w.length;i++)
//        {System.out.println("");
//            for(int j=0; j<W+1;j++) {
//                System.out.print(data[i][j]+",");
//            }
//        }
//        if(data[w.length-1][W]==W){
            int x= w.length-1;
            int y = W;
        List<Integer> list= new ArrayList<Integer>();

            while(data[x][y]!=0) {
//                System.out.println("value of x is "+ x + " y is "+y);
                if(x==0){
                    list.add(w[x]);
                    y=y-1;
                    break;
                }
                if(data[x][y]==data[x-1][y]){
//                    if(y-w[x]>=0){
//    //                    y = y-w[x];
//                        list1.add(w[x]);
//                    }
                    x=x-1;

                }
                else{
                    list.add(w[x]);

//                    System.out.println("value of x is "+ x);
//                    System.out.println(list.get(i));
                    y = y-w[x];
                    x=x-1;



                }

            }

        x= w.length-1;
        y = W;

        List<Integer> list1= new ArrayList<Integer>();

        while(data[x][y]!=0) {
//                System.out.println("value of x is "+ x + " y is "+y);
            if(x==0){

                list1.add(w[x]);
                y=y-1;
                break;
            }
            if(data[x][y]==data[x-1][y]){
                if(y-w[x]>=0){
                    y = y-w[x];
                    list1.add(w[x]);
                }
                x=x-1;

            }
            else{

                list1.add(w[x]);
//                    System.out.println("value of x is "+ x);
//                    System.out.println(list.get(i));
                y = y-w[x];
                x=x-1;



            }

        }
//            for(int j=0;j<set1.length;j++ ){
//                System.out.println(","+set1[j]);
//            }
//        List<Integer> list = new ArrayList<Integer>(Arrays.asList(set1));
//        list.removeAll(Arrays.asList(Integer.valueOf(0)));
//        Integer [] set1 = list.toArray(new Integer[list.size()]);
//        System.out.println("asafsasdfasdf"+list.stream().mapToInt(p->p).toArray().length);
        if(IntStream.of(list1.stream().mapToInt(p->p).toArray()).sum()==W){
            return list1.stream().mapToInt(p->p).toArray();
        }
            return   list.stream().mapToInt(p->p).toArray();


//        else{
//            return 0;
//        }
    }
    private static int partition3(int[] w) {

        int s=IntStream.of(w).sum();
//        System.out.println("here you are "+s);
        if(s%3==0 && w.length>=3){

            int W=s/3;
            int[] set =findPair(w, W);
//            System.out.println("First Pair is ");
//            for(int i=0;i<set.length;i++){
//                System.out.print(set[i]+" ,");
//            }
//            System.out.println("");
//            System.out.println("");
            if(IntStream.of(set).sum()==W){
               int[] p = intersect(w,set);
               int[] n = findPair(p, W);
//                System.out.println("Second Pair is ");
//                for(int i=0;i<n.length;i++){
//                    System.out.print(n[i]+" ,");
//                }
//                System.out.println("");
//                System.out.println("");
//               System.out.println("IntStream.of(n).sum()"+IntStream.of(n).sum());
//                System.out.println("IntStream.of(intersect(p,n)).sum())"+IntStream.of(intersect(p,n)).sum());
                if((IntStream.of(n).sum()==IntStream.of(intersect(p,n)).sum()) && IntStream.of(n).sum()==W){

                    return 1;
                }
                else{
                    return 0;
                }
            }
            else {return 0;}
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
//        int n = 11;
//        int[] A ={1 ,2 ,3 ,3,4,5} ;
//        int[] A ={3,3,3,3 };
//        int[] A ={1, 12 ,17 ,29, 18, 13};
//        int[] A= {9, 20, 6, 6, 8, 2, 4, 5};
//
        System.out.println(partition3(A));
    }
}


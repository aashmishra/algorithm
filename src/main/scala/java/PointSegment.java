import java.util.*;
import java.util.Scanner;

public class PointSegment {
    public void merge(List<Tuple> arr, int start, int mid, int end){
        int s = mid-start;
//        System.out.println("s->"+s);

        int e = end-mid;
//        System.out.println("e->"+e);
        List<Tuple> left =new ArrayList<Tuple>(arr.subList(start,mid));
//        System.out.println("left.size()->"+left.size());
//        System.out.println("start-->"+(start)+", mid+1->"+(mid+1));
//        for(int i=0;i<left.size();i++)
//            System.out.println("left->"+left.get(i).values+", for i->"+i);


//        System.out.println("mid+1-->"+(mid+1)+", end+1->"+(end+1));
        List<Tuple> right = new ArrayList<Tuple>(arr.subList(mid,end));
//        System.out.println("right.size()->"+right.size());
//        for(int i=0;i<right.size();i++)
//            System.out.println("right->"+right.get(i).values);




        int j=0;
        int i=0;
        int k =start;
        while(i<s && j<e){

            if(left.get(i).values<=right.get(j).values){
//                System.out.println(left.get(i).values+" >= "+right.get(j).values);
                if(left.get(i).values==right.get(j).values && left.get(i).types.compareTo(right.get(j).types)>0) {
                    arr.set(k, right.get(j));
                    j++;
                }
                    else
                {
                    arr.set(k,left.get(i));
                    i++;
                }
            }
            else{
//                System.out.println(left.get(i).values+" < "+right.get(j).values);
                arr.set(k,right.get(j));
                j++;
            }
            k++;
//            System.out.println("i="+i+", j="+j+", k="+k);
        }

        while(i<s){
            arr.set(k,left.get(i));
            i++;
            k++;
        }

        while(j<e){
            arr.set(k,right.get(j));
            j++;
            k++;
        }
//        System.out.println("");
//        for(int p =start;p<k;p++){
//            System.out.print(","+arr.get(p).values);
//        }
//        System.out.println("");


    }
    public void sort(List<Tuple> arr, int start, int end){
        if(start+1<end) {
            int mid = (start+end) / 2;
//            System.out.println("start="+start+", end="+end+", mid="+mid);
            sort(arr, start, mid);
            sort(arr, mid , end);
            merge(arr, start, mid, end);
        }
}
    class Tuple{
        protected String types;
        protected int values;
        public Tuple(int values, String types){
            this.values=values;
            this.types=types;
        }

    }


        private int[] fastCountSegments(int[] starts, int[] ends, int[] points,int n) {
           int [][] ar = new int[n][2];
            List<Tuple> ls = new ArrayList<>(n);

           for(int i = 0;i<starts.length  ;i++){
                ls.add(new Tuple(starts[i], "l"));
                ls.add(new Tuple(ends[i], "r"));

            }
            for(int i = 0;i<points.length  ;i++){
                ls.add(new Tuple(points[i], "p"));

            }
            sort(ls, 0,n+starts.length);
//            for(int i = 0;i<n+starts.length  ;i++){
//                ls.get(i);
//                ls.add(new Tuple(ends[i], "l"));
//                System.out.println(ls.get(i).values +" "+ ls.get(i).types);
//            }
int count=0;
            int j=0;
int[] x = new int[points.length];
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            for(int i = 0;i<n+starts.length  ;i++){
//                ls.get(i);
//                ls.add(new Tuple(ends[i], "l"));

                if(ls.get(i).types=="p"){
                    map.put(ls.get(i).values,count);
                    j++;
                }else if(ls.get(i).types=="l"){count++;}
                else{count--;}
//                System.out.println(ls.get(i).values +" "+ ls.get(i).types);
            }

//            int[] x = {1,2,3};
            for(int i = 0;i<points.length;i++)
            {
                x[i]=map.get(points[i]);
            }
            return x;
        }

        private int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
            int[] cnt = new int[points.length];
            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < starts.length; j++) {
                    if (starts[j] <= points[i] && points[i] <= ends[j]) {
                        cnt[i]++;
                    }
                }
            }
            return cnt;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n, m;
            n = scanner.nextInt();
            m = scanner.nextInt();
//        m=3;
//        n=2;
            int[] starts = new int[n];
            int[] ends = new int[n];
//        long[][] arr = new long[n][n];
            int[] points = new int[m];
            for (int i = 0; i < n; i++) {
                starts[i] = scanner.nextInt();
                ends[i] = scanner.nextInt();
//            arr[i][0] = scanner.nextLong();
//            arr[i][1] = scanner.nextLong();
            }
//        int[] starts={-10,-10};
//        int[] ends = {10,10};
            for(int i = 0; i < m; i++) {
                points[i] = scanner.nextInt();
            }
//        int[] points = {-10,10,11};
            //use fastCountSegments
            PointSegment x = new PointSegment();
            int[] cnt = x.fastCountSegments(starts, ends, points,n+m);
            for (int y : cnt) {
                System.out.print(y + " ");
            }
        }
    }


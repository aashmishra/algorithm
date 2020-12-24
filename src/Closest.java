import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable<Point> {
        protected int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    class Sortbyx implements Comparator<Point>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Point a, Point b)
        {
            return a.x - b.x;
        }
    }

    class Sortbyy implements Comparator<Point>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Point a, Point b)
        {
            return a.y - b.y;
        }
    }


    public void minimalDistance(ArrayList<Point> ls, int n) {

        Collections.sort(ls, new Sortbyx());
//        System.out.println("Sorted By X:->");
//        for(int i=0; i<n;i++)
//        {
//            System.out.print(","+ls.get(i).x);
//        }
        Collections.sort(ls, new Sortbyy());
//        System.out.println("Sorted By Y:->");
//        for(int i=0; i<n;i++)
//        {
//            System.out.print(","+ls.get(i).y);
//        }
    }
    public double distance(Point p1, Point p2){
        return Math.sqrt((p1.x-p2.x)^2+(p1.y-p2.y)^2);
    }
    public double bruteDistance(ArrayList<Point> ls, int start, int end) {
        double minDistance = 0;
        double distance;

        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                distance = distance(ls.get(i),ls.get(j));
                if(distance<minDistance){
                    minDistance=distance;
                }
            }


        }
        return minDistance;
    }
    public double getDistance(ArrayList<Point> ls, int start, int end){
        if(end-start<10){
            bruteDistance(ls,start,end);
        }
        int middle = (end-start)/2;
        double left = getDistance(ls,start,middle);
        double right = getDistance(ls,middle+1,end);
        double localMin ;
        if(left>right){
            localMin= right;
        }
        else {
            localMin= left ;
        }
        double mind = merge(ls, start, end, localMin);
        return mind;
    }
    public double merge(ArrayList<Point> ls, int start, int end, double localMin){
        List<Point> l =new ArrayList<Point>();
        List<Point> r =new ArrayList<Point>();
        int middle = (end-start)/2;
        for(int i=start;i<=end;i++){
            if(ls.get(i).x<=middle+localMin && ls.get(i).x>=middle){
             l.add(ls.get(i));
            }
            else{
                r.add(ls.get(i));
            }
        }
        int m =0;
        int j=0;
        int k =0;
        int rightMax= m;

        Collections.sort(l, new Sortbyy());
        Collections.sort(r, new Sortbyy());

        m=0;
        double min=localMin,minl=localMin;
        for(int i=0;i<l.size();i++){
            while(j<r.size() && l.get(i).y-localMin>r.get(j).y)
                j++;

            k=j;
            while(k<r.size() && l.get(i).y+localMin>=r.get(k).y){
                minl=distance(l.get(i),r.get(k));
                if(minl<min){
                    min=minl;
                    Point p1 = l.get(i);
                    Point p2 = r.get(k);
                }
                k++;
            }

        }
        return min;
    }


    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = 4;
//        int n = nextInt();
//        int[] x = new int[n];
//        int[] y = new int[n];
        ArrayList<Point> ls = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            ls.add(new Point(nextInt(),nextInt()));
//        }
        ls.add(new Point(1,2));
        ls.add(new Point(2,1));
        ls.add(new Point(5,0));
        ls.add(new Point(-1,3));
        System.out.println(ls.size());
        for(int i=0; i<n;i++)
        {
            System.out.print(","+ls.get(i).x);
        }
        new Closest().minimalDistance(ls,n);
//        System.out.println(minimalDistance(ls,n));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}

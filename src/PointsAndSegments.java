import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        int max=ends[0];
        int min=starts[0];
        int map=points[0];
        int mip=points[0];
        for(int i =0;i< starts.length;i++) {
            if (max < ends[i]) {
                max = ends[i];
            }
            if (min > starts[i]) {
                min = starts[i];
            }
        }
//        System.out.println("max-->"+max);
//        System.out.println("min-->"+min);

        for(int i =0;i< points.length;i++){
            if (map < points[i]) {
                map = points[i];
            }
            if (mip > points[i]) {
                mip = points[i];
            }
        }
//        System.out.println("map-->"+map);
//        System.out.println("mip-->"+mip);
        int limitStart = Math.max(min,mip);
        int limitEnd = Math.min(max,map);
//        System.out.println("limitStart-->"+limitStart);
//        System.out.println("limitEnd-->"+limitEnd);

        int len = Math.abs(limitEnd-limitStart)+2;
//        System.out.println("len-->"+len);
        int[] result = new int[len];
        int count=0;

        for(int i=0;i<starts.length;i++) {
//            System.out.println(starts[i] +"<"+ limitStart+" && "+ends[i]+" >= "+limitStart);
            if (starts[i] <limitStart && ends[i] >= limitStart) {
                count += 1;
            }
        }
//        System.out.println("count-->"+count);
        for(int i=0;i<starts.length;i++) {
//            if(limitStart<0 && starts[i]>=limitStart && starts[i]<0 ){
//                result[starts[i]]
//            }
            if(starts[i]>=limitStart && starts[i]<=limitEnd)
            {
                result[starts[i]-limitStart]=result[starts[i]-limitStart]+1;
            }
            if(ends[i]>=limitStart && ends[i]<=limitEnd) {
                result[ends[i] - limitStart+1] = result[ends[i] - limitStart+1]-1;
            }

        }
        result[0]=result[0]+count;
//        System.out.println("result before-->");
//        for(int i=0;i<len;i++) {
//            System.out.print(result[i]+",");
//        }
        int j=0;
        for(int i=1;i<len;i++) {
            result[i]=result[i]+result[i-1];
        }
//        System.out.println("");
//        System.out.println("result after-->");
//        for(int i=0;i<len;i++) {
//            System.out.print(result[i]+",");
//        }
//        System.out.println("");
        for(int i =0;i< points.length;i++){
            if(points[i]>=limitStart && points[i]<=limitEnd && result[points[i]-limitStart]>0){

                cnt[i]=result[points[i]-limitStart];
            }
        }

        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
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
//        n=3;
//        m=2;
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
//        int[] starts={-10,-10,2};
//        int[] ends = {10 , 10,4};
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
//        int[] points = {-10,10};
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

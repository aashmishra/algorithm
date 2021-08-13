import java.util.*;

public class CoveringSegments {

    private static Integer[] optimalPoints(Segment[] segments) {
        //write your code here
        Integer[] points = new Integer[2 * segments.length];
        int j =1;
        int currentPoints=segments[0].end;
        points[0]=segments[0].end;
        for (int i = 0; i < segments.length; i++) {
            if(currentPoints> segments[i].end || currentPoints<segments[i].start){
                points[j]=segments[i].end;
                j=j+1;
                currentPoints = segments[i].end;
            }
        }
        return points;
    }

    private static class Segment{
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;}
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }

        java.util.Arrays.sort(segments,Comparator.comparing(segment -> segment.end));
//        for (int i = 0; i < n; i++) {
//            System.out.println(segments[i].start + " " + segments[i].end);
//        }
        Integer[] points = optimalPoints(segments);
        List<Integer> listt = new ArrayList<Integer>(Arrays.asList( points));
        listt.removeAll(Collections.singleton(null));
        points = listt.toArray(new Integer[listt.size()]);
        System.out.println(points.length);
        for (Integer point : points) {
            System.out.print(point + " ");
        }
//        System.out.println(Arrays.toString(points));

//        Integer[] numbers = {1, 3, 6, 0, 4, 0, 3};
//        List<Integer> list = new ArrayList<Integer>(Arrays.asList(numbers));
//        list.removeAll(Arrays.asList(Integer.valueOf(0)));
//        numbers = list.toArray(new Integer[list.size()]);
//        System.out.println(Arrays.toString(numbers));
    }
}
 

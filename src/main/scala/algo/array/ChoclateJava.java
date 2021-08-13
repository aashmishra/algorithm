package algo.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ChoclateJava {
    public static long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        long min = Integer.MAX_VALUE;
        Collections.sort(a);
        for(int i=0;i<=n-m;i++) {
            min=Math.min(min,(a.get(((int) m)+i - 1) - a.get(i)));
        }
        return min;
        // your code here
    }

    public static void main(String[] args) {
        ArrayList<Long> l = new ArrayList<>(9);
        l.add((long)17);
        l.add((long)83);
        l.add((long)59);
        l.add((long)25);
        l.add((long)38);
        l.add((long)63);
        l.add((long)25);
        l.add((long)1);
        l.add((long)37);

        System.out.println(findMinDiff(l,9,9));

    }
}

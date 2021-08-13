package algo.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumberConcatArrayJava {
    static String printLargest(String[] arr) {
        // code here
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String xy = o1+o2;
                String yx = o2+o1;
                return xy.compareTo(yx)>0 ? -1 : 1 ;
            }
        });

       return String.join("",arr);

    }

    public static void main(String[] args) {
        String[] s = {"3", "30", "34", "5", "9"};

        System.out.println(printLargest(s));
    }
}

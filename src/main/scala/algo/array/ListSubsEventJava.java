package algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSubsEventJava {


    static Boolean  binarySearch(String[] s, int start, int end, String target){
        if(start>end) return false;
        int middle = (start+end)/2;
        if(s[middle].compareTo(target)==0) {return true;}
        if(s[middle].compareTo(target)>0) { return  binarySearch(s,start, middle-1, target);}
        else { return binarySearch(s,middle+1, end, target);}
    }
    static String[] search(String[] s1, String[] s2){
        List<String> res = new ArrayList<String>();
        if(s1.length>s2.length){
            Arrays.sort(s2);
            for(int i=0;i<s1.length;i++){
                if(binarySearch(s2,0,s2.length-1,s1[i])){
                    res.add(s1[i]);
                }
            }
        } else {
            Arrays.sort(s1);
            for(int i=0;i<s2.length;i++){
                if(binarySearch(s1,0,s1.length-1,s2[i])){
                    res.add(s2[i]);
                }
            }
        }
        String[] arr = new String[res.size()];
        arr = res.toArray(arr);
        return arr;
    }

    public static void main(String[] args) {
        String[] evt1 = {"aman","ashis"};
        String[] evt2 = {"a","aman","ashis", "x"};
        String[] res =search(evt1,evt2);
        for(int i=0; i<res.length;i++){
            System.out.println(res[i]);
        };

    }


}

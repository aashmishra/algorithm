package algo.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutStringJava {


    String swap(String s,int i, int j){
        char[] chars = s.toCharArray();
        char temp;
        temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;

        return String.valueOf(chars);
    }

    List<String> generatePermutation(String s ,int start,int end){
        List<String> res = new ArrayList<>();
        if(start==end-1){
             res.add(s) ;
        } else {
            for(int i=start; i<end;i++){
                s = swap(s, start, i);
                res.addAll(generatePermutation(s, start+1, end));
                s = swap(s, start, i);
            }
        }
        return res;
    }

    public List<String> find_permutation(String S) {
        List<String> result = new ArrayList<String>();
        result.addAll(generatePermutation(S, 0, S.length()));
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        String data = "ljr";
        PermutStringJava x = new PermutStringJava();
        x.find_permutation(data).forEach(elem -> System.out.println(elem));

    }

}

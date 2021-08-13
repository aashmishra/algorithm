package algo.String;

import java.util.Collections;

public class ReverseWordsJava {
   static String reverseWords(String S)
    {
        String[] m = S.split("\\.");
        StringBuilder sbStr = new StringBuilder();
        for(int j=m.length-1;j>=1;j--){
            sbStr.append(m[j]);
            sbStr.append(".");
        }
        sbStr.append(m[0]);
        return sbStr.toString();
    }

    public static void main(String[] args) {
        String m = "i.like.this.program.very.much";
        System.out.println(reverseWords(m));
    }
}

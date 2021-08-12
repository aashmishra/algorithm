package algo.String;

import java.util.HashMap;
import java.util.Stack;

public class RemoveDuplicateStringJava {


    public class RemainingLastRemoved{
        public String remaining;
        public Character lastRemoved;
        public RemainingLastRemoved(String remaining,Character lastRemoved ){
            this.remaining=remaining;
            this.lastRemoved=lastRemoved;
        }
    }


    public  RemainingLastRemoved removeRec(String s, Character lastRemoved){
        //if length is zero or one return the string as it is
        if(s.length()==1 || s.length()==0){
            return new RemainingLastRemoved(s, '0');
        }

        // if repeating characters are there
        if(s.charAt(0)==s.charAt(1)){
            Character newlastRemoved = s.charAt(0);
            while (s.length()>1 && s.charAt(0)==s.charAt(1)){
//                System.out.println(s);
                s= s.substring(1, s.length());
            }
            s = s.substring(1, s.length());
        return removeRec(s, newlastRemoved);
        }

        // get the remaining string
//        System.out.println(s.substring(1, s.length()) + "->" + lastRemoved);
        RemainingLastRemoved rem = removeRec(s.substring(1, s.length()), '0');
//        System.out.println(rem.remaining + "-------    ->" + rem.lastRemoved);

        if(rem.remaining.length()>0 && rem.remaining.charAt(0)==s.charAt(0)){
            lastRemoved = s.charAt(0);
            return new RemainingLastRemoved(rem.remaining.substring(1,rem.remaining.length() ),lastRemoved );
        }

        if(lastRemoved==s.charAt(0) || rem.lastRemoved==s.charAt(0)){
//            System.out.println(rem.remaining +"   "+rem.lastRemoved);
            return rem;
        }

        return new RemainingLastRemoved(s.charAt(0)+rem.remaining, lastRemoved);
    }


    String remove(String s) {

//    return  removed(s, '0').remainingString;
        char last_removed = '\0';
        return removeRec(s, '0').remaining;
    }

    public static void main(String[] args) {
//        String data = "acaaabbbacdddd";
//        String data = "offevqqszsaksjyyyiirrdddwwddbbhwwyyjjivwaaxdmhuumssszxxeeeuuqppaliirrfddn";
//        String data = "oooosssnnyyhtffffylnqohhjgnnnqoozooccfpgwuutjyzzzvvvseagyvddj";
//        String data = "abccbccba";
        String data = "abcccbbccba";

        RemoveDuplicateStringJava x = new RemoveDuplicateStringJava();
        System.out.println(x.remove(data));
//        System.out.println("htylnqojgqzfpgwtjyseagyvj");
//        System.out.println("oevszsaksjhivwxdmhmzqalfn");
    }
}

import java.math.BigInteger;
import java.util.*;

public class LargestNumber {
    public static int largenew(String o1, String o2) {
        if (new BigInteger(o1+o2).compareTo(new BigInteger(o2+o1))<0){
    return -1;
        }
        return 1;
    }
    public static int large(String o1, String o2) {
        int limit;
        String Large;
        String Small;
        if(o1.length()>o2.length()){
            limit=o2.length();
            Large = o1;
            Small = o2;
        }
        else{
            limit=o1.length();
            Large=o2;
            Small = o1;
        }
        if(Integer.valueOf(o1.substring(0,limit))>Integer.valueOf(o2.substring(0,limit))){
//                    System.out.println((o2+"<"+o1));
            return -1;
        }
        else{
            if(Integer.valueOf(o1.substring(0,limit))==Integer.valueOf(o2.substring(0,limit)) && o1.length()!=o2.length()){
                int newLimit =  Math.min(Large.substring(Small.length()).length(), Small.length());
//                        System.out.println("newLimit->"+newLimit);
//                        System.out.println("Limit->"+limit);
//                        System.out.println("Large.substring(limit,limit+newLimit)-->"+Large.substring(limit,limit+newLimit));
//                        System.out.println("Small.substring(0,newLimit)-->"+Small.substring(0,newLimit));
                if(Integer.valueOf(Large.substring(limit,limit + newLimit))<Integer.valueOf(Small.substring(0,newLimit))){
//                            System.out.println((Large+"<"+Small));
                    if(Large==o2){
//                                System.out.println((o1+"<"+o2));
                        return -1;}
//                            else{
////                                System.out.println((o1+">"+o2));
//                                return -1;
//                            }
                }
            }
        }
        return 1;
    }
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        String temp;
        for (int i = 0; i < a.length-1; i++) {
            for(int j=i+1;j<a.length;j++){
                if(largenew(a[i],a[j])<1){
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;

                }
            }


        }
        for (int i = 0; i < a.length; i++) {
        result += a[i];}
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
//        Arrays.sort(a, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int limit;
//                String Large;
//                String Small;
//                if(o1.length()>o2.length()){
//                    limit=o2.length();
//                    Large = o1;
//                    Small = o2;
//                }
//                else{
//                    limit=o1.length();
//                    Large=o2;
//                    Small = o1;
//                }
//                if(Integer.valueOf(o1.substring(0,limit))>Integer.valueOf(o2.substring(0,limit))){
////                    System.out.println((o2+"<"+o1));
//                    return -1;
//                }
//                else{
//                    if(Integer.valueOf(o1.substring(0,limit))==Integer.valueOf(o2.substring(0,limit)) && o1.length()!=o2.length()){
//                        int newLimit =  Math.min(Large.substring(Small.length()).length(), Small.length());
////                        System.out.println("newLimit->"+newLimit);
////                        System.out.println("Limit->"+limit);
////                        System.out.println("Large.substring(limit,limit+newLimit)-->"+Large.substring(limit,limit+newLimit));
////                        System.out.println("Small.substring(0,newLimit)-->"+Small.substring(0,newLimit));
//                        if(Integer.valueOf(Large.substring(limit,limit + newLimit))<Integer.valueOf(Small.substring(0,newLimit))){
////                            System.out.println((Large+"<"+Small));
//                            if(Large==o2){
////                                System.out.println((o1+"<"+o2));
//                                return -1;}
////                            else{
//////                                System.out.println((o1+">"+o2));
////                                return -1;
////                            }
//                        }
//                    }
//                }
//                return 1;
//            }
//        });
        System.out.println(largestNumber(a));
//        System.out.println(largenew("21","2"));
////        System.out.println(largenew("2","21"));
////        System.out.println(largenew("40","21"));
   }

}


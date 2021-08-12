package algo.array;

public class LastIndexOfOne {

    public int lastIndex( String s) {
        String[] a = s.split("");
        for(int i=a.length-1;i>=0;i--){
            System.out.println(a[i]);
            if( a[i].equals("1")){
                return i;
            }
        }
        return -1;

    }
}

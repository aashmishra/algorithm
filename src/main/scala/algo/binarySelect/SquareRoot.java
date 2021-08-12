package algo.binarySelect;

public class SquareRoot {
    public static double sqrt (int data,int p){
        if(data==1) return 1;
        long min=1, max=data, mid=0;
        while(max>=min){
            mid=(min+max)/2;
//            if(mid==data/mid) return mid;
            if(mid<data/mid){
                min=mid+1;
            } else {
                max=mid-1;
            }
            System.out.println("max-> "+max+ "min-> "+min);
        }
        if(min>data/mid) mid=mid-1;
        double res= ((double) mid);
        double ores= ((double) mid);
        System.out.println("mid->"+res);
        double x;
        for(int i =1; i<=p;i++){
            x=0;
            System.out.println("i "+i);
            while(res<data/res && x<=9){
                if(res==data/res) return res;
                res=res+x/(Math.pow(10,i));
                x++;
            }
            res=ores+(x-1)/(Math.pow(10,i));
            ores=res;
        }
        return res;
    }
//    public static int mySqrt(int data) {
//        if(data==1) return 1;
//        int length = (int)(Math.log10(data)+1);
//        System.out.println("length "+length);
//        long min=1, max=0, mid=1;
//        if(length==1){
//            max=data/2;
//        } else {
//            int hlength=length/2;
//            System.out.println("hlength "+hlength);
//            while(hlength>0){
//                max=max+9*((int) Math.pow(10,hlength--));
//            }
//            max=max/10;
//        }
//        System.out.println("here max is "+max);
//        System.out.println("");
//        while(max>=min){
//            mid=(min+max)/2;
//            if(mid*mid==data) return (int)mid;
//            if(mid*mid<data){
//                min=mid+1;
//            } else {
//                max=mid-1;
//            }
//        }
//        if(mid*mid>data) mid=mid-1;
//        return (int)mid;
//    }
    public static void main(String[] args) {
        System.out.println(sqrt(5,2));
//        System.out.println(mySqrt(2147395599));
    }
}

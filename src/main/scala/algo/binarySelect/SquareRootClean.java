package algo.binarySelect;

public class SquareRootClean {

    public static float sqrt(int x, int p){
        int min=0,max=x/2;
        float mid=0;
        double res=0;
        while(max>=min){
            mid=(min+max)/2;
            if(mid>x/mid){
                max=(int) mid-1;
            } else {
                min= (int)mid+1;
                res=mid;
            }
        }
//        return res;
        double inc = 0.1;
        for(int i=0;i<p;i++){
            while(res<=x/res){
                res=res+inc;
            }
            res=res-inc;
            inc=inc/10;
            System.out.println(inc);
        }
      return (float)res;
    }
    public static void main(String[] args) {
        System.out.println(sqrt(5,2));
    }
}

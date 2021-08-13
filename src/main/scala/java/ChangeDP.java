import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here
        int coin[] = {0,1,3,4};
        int x [][] = new int[4][m+1] ;
        x[0][0]=0;
        x[1][0]=0;
        x[2][0]=0;
        x[3][0]=0;
        for(int i =1;i<=m;i++){
            x[0][i]=x[0][i-1]+1;

        }
//        for(int i =0;i<=3;i++){
//            for(int j=0;j<=m; j++){
//                System.out.print(x[i][j]+",");
//  }
//            System.out.println("");
//        }
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
        for(int i =1;i<=3;i++){
            for(int j=1;j<=m; j++){
                if(j<coin[i]){
                    x[i][j]=x[i-1][j];
                    continue;
                }
                if(((x[i][j-coin[i]]+1)> x[i-1][j])){
                    x[i][j]=x[i-1][j];
                }
                else{
                    x[i][j]=(x[i][j-coin[i]]+1);
                }
            }
        }
//        for(int i =0;i<=3;i++){
//        for(int j=0;j<=m; j++){
//            System.out.print(x[i][j]+",");
//        }
//        System.out.println("");
//    }
        return x[3][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
//        int m = 11;
        System.out.println(getChange(m));


    }
}


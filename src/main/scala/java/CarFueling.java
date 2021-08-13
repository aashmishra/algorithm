import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops,int[] real,int n) {
        int currentdistance=0;
        int j =0;
        int stop=0;
        currentdistance = currentdistance+tank;
        if(currentdistance>= dist){
            return 0;
        }
        while(currentdistance<=dist){
            if((currentdistance<dist && stop==n-1) || (currentdistance<stops[j])){
                      return -1;
                  }
                  for(int i=j; i<n;i++){
                      if(currentdistance>=stops[i] && currentdistance<=dist){
                          stop  =i;
                            if(stops[stop]+tank>=dist){
                                real[stop] = 1;
                                break;
                            }
                      }
                      else{
                              real[stop] = 1;
                              j=stop+1;
                          currentdistance = stops[stop];
                              break;
                  }
                  }
            currentdistance = currentdistance+tank;
            }

        int sum=0;
        for(int i=0 ; i<n;i++){
            sum=real[i]+ sum;
        }

        if(sum==0){
            return -1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        int real[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops, real,n));
    }
}

import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
    int a = s.length();
    int b = t.length();

    int [][] x = new int[b+1][a+1];
    for(int i=0;i<=a;i++)
    {
      x[0][i]=i;
    }
    for(int j=0;j<=b;j++)
    {
      x[j][0]=j;
    }
    for(int i=1;i<=b;i++)
    {
      for(int j=1;j<=a;j++)
    {
      if(s.charAt(j-1)==t.charAt(i-1)){
        x[i][j]=x[i-1][j-1];
      }
      else{
        x[i][j]=Math.min(Math.min(x[i-1][j],x[i][j-1]),x[i-1][j-1])+1;
      }
    }
    }
    return x[b][a];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}

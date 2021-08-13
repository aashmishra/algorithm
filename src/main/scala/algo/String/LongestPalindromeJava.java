package algo.String;

public class LongestPalindromeJava {
    static String longestPalin(String S){
        // code here
        char[] input  = S.toCharArray();
        int[][] dp = new int[S.length()][S.length()];
        int maxi = 0;
        int maxj = 0;
        int max = 1;
        for(int i=0;i<S.length();i++){
            dp[i][i]=1;
        }


        for(int i=0;i<S.length()-1 ;i++){
            if(input[i]==input[i+1]) {dp[i][i+1]=2; if(max==1){ max=2; maxi=i; maxj=i+1;} }
        }
        int j = -1;
        for(int k= 3; k<=S.length();k++){
            for(int i=0;i<= S.length()-k;i++) {
                j= i+k-1;
                if(input[i]==input[j] && dp[i+1][j-1]>0 ){
                    dp[i][j] = dp[i+1][j-1] + 1;
                    if(k>max) {max = k; maxi=i; maxj=j;}
                }
            }
        }

       return S.subSequence(maxi,maxj+1).toString();
    }

    public static void main(String[] args) {
        String data = "kjqlrzzfmlvyoshiktodnsjjp";
        System.out.println(longestPalin(data));
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception     {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        for (int i = 0; i < val.length; i++) {
            val[i] = scn.nextInt();
        }
        int[] wt = new int[n];
        for (int i = 0; i < wt.length; i++) {
            wt[i] = scn.nextInt();
        }
        int W = scn.nextInt();

        int[][] dp = new int[n+1][W+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }else if(j>=wt[i-1]){
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][W]);
    }
}
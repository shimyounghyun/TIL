import java.util.*;

class Solution {
    static final int MOD = 1000000007;
    
    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length+1][n+1];
        Arrays.sort(money);
        dp[0][0] = 1;
        
        for (int r=1; r<dp.length; r++){
            for (int c=0; c<=n; c++){
                if (c < money[r-1]){
                    dp[r][c] = dp[r-1][c] % MOD;
                }else if (c == money[r-1]){
                    dp[r][c] = dp[r-1][c]+1%MOD;
                }else {
                    dp[r][c] = dp[r-1][c] + dp[r][c - money[r-1]] % MOD;
                }
            }
        }
        
        return dp[money.length][n];
    }
}

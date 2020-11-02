import java.util.*;

class Solution {
    final static long MOD = 10000019;
    long[][] nCr;

    public int solution(int[][] a) {
        nCr = new long[a.length+1][a.length+1];
        for (int i=0; i<=a.length; i++){
            for (int j=0; j<=i; j++){
                if (j == 0 || j == i) nCr[i][j] = 1;
                else nCr[i][j] = (nCr[i-1][j-1] + nCr[i-1][j]) % MOD;
            }
        }
        
        int[] count = new int[a[0].length+1];
        for (int i=0; i<a.length; i++){
            for (int j=0; j<a[i].length; j++){
                count[j+1] += a[i][j];
            }
        }
        
        int n = a.length;
        int m = a[0].length;
        
        // System.out.println(Arrays.toString(count));
        long[][] dp = new long[m+1][n+1];
        dp[1][n-count[1]] = nCr[a.length][count[1]];
        // System.out.println(dp[1][count[1]]);
    
        
        for (int i=1; i<m; i++){ // 열
            int c = count[i+1];
            for (int j=0; j<=n; j++){ // 짝수인 개수
                if (dp[i][j] == 0) continue;
                for (int k=0; k<=c; k++){
                    int odd = c - k;
                    int row = (j-k) + odd;
                    if (row > n || row < 0) continue;
                    
                    long result = nCr[j][k] * nCr[a.length-j][odd] % MOD;
                    dp[i+1][row] += dp[i][j] * result % MOD;
                    dp[i+1][row] %= MOD;
                }
            }
        }
        return (int)dp[m][n];
    }
}
// 2 3 :

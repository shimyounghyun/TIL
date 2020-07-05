import java.util.*;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] c) {
        int[][] v = new int[m+1][n+1];
        int[][] h = new int[m+1][n+1];
        v[1][1] = h[1][1] = 1;
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (c[i-1][j-1] == 0){
                    v[i][j] += (v[i-1][j]+h[i][j-1])%MOD;
                    h[i][j] += (v[i-1][j]+h[i][j-1])%MOD;
                }else if (c[i-1][j-1] == 1){
                    v[i][j] = 0;
                    h[i][j] = 0;
                }else {
                    v[i][j] = v[i-1][j];
                    h[i][j] = h[i][j-1];
                }
            }
        }
        return v[m][n];
    }
}

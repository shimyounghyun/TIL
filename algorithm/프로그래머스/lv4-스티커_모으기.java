import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int[][] dp = new int[2][sticker.length];
        if (sticker.length == 1){
            return sticker[0];
        }else if (sticker.length == 2){
            return Math.max(sticker[0], sticker[1]);
        }else if (sticker.length == 3){
            return Math.max(sticker[0], Math.max(sticker[1],sticker[2]));
        }
        dp[0][0] = sticker[0]; // 14
        dp[0][1] = sticker[1]; // 6
        dp[0][2] = sticker[2] + dp[0][0];
        
        dp[1][1] = sticker[1]; // 6
        dp[1][2] = sticker[2]; // 5
        dp[1][3] = sticker[3] + dp[1][1];
        
        int lmax = Math.max(dp[0][1], dp[0][2]);
        for (int i=3; i<sticker.length-1; i++){
            dp[0][i] = Math.max(dp[0][i-2], dp[0][i-3])+sticker[i];
            lmax = Math.max(lmax, dp[0][i]);
        }
        int rmax = Math.max(dp[1][2], dp[1][3]);
        for (int i=4; i<sticker.length; i++){
            dp[1][i] = Math.max(dp[1][i-2], dp[1][i-3])+sticker[i];
            rmax = Math.max(rmax, dp[1][i]);
        }
        return Math.max(lmax, rmax);
    }
}

import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] dp = new int[a.length];
        int[] rdp = new int[a.length];
        dp[0] = a[0];
        rdp[a.length-1] = a[a.length-1];
        for (int i=1; i<a.length; i++){
            dp[i] = Math.min(dp[i-1], a[i]);
        }
        for (int i=a.length-2; i>=0; i--){
            rdp[i] = Math.min(rdp[i+1], a[i]);
        }
        for (int i=0; i<a.length; i++){
            if (i == 0 || i == a.length-1){
                answer++;
            }else if (dp[i-1] > a[i] || a[i] < rdp[i+1]){
                answer++;   
            }
        }
        return answer;
    }
}

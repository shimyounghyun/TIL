import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] ans = new int[n+3];
        
        for (int i : reserve){
            ans[i] = 1;
        }
        for (int i : lost){
            ans[i]--;
        }
        for (int i=1; i<=n; i++){
            if (ans[i] >= 0){
                answer++;
            }else{
                if (ans[i-1] > 0){
                    ans[i-1]--;
                    answer++;   
                }else if (ans[i+1]>0){
                    ans[i+1]--;
                    answer++;
                }
            }
        }
        return answer;
    }
}

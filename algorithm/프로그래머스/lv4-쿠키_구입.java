import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int[] sum = new int[cookie.length];
        sum[0] = cookie[0];
        for (int i=1; i<sum.length; i++)
            sum[i] = sum[i-1] + cookie[i];
        
        for (int i=0; i<sum.length-1; i++){
            int a = sum[i];
            for (int j=i+1; j<sum.length; j++){
                int b = sum[j] - a;
                if (a < b) break;
                if (b < answer) continue;
                if (a == b){
                    answer = Math.max(answer, a);
                    break;
                }
                for (int k=0; k<=i; k++){
                    if (a - sum[k] == b)
                        answer = Math.max(answer, a - sum[k]);
                    else if (a - sum[k] < b) break;
                }
            }
        }
        return answer;
    }
}

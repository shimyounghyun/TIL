import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s/n == 0){
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[n];
        Arrays.fill(answer, s/n);
        
        int extra = s%n;
        int i = n-1;
        while (i >= 0 && extra > 0){
            answer[i]++;
            i--;
            extra--;
        }
        
        return answer;
    }
}

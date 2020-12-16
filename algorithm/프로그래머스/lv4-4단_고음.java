import java.util.*;

class Solution {
    int answer = 0;
    public void dfs(int v, int c){
        if (v == 1){
            if (c == 0) answer++;
            return;
        }
        if ((int)Math.pow(3, c/2)>v) return;
        if (v % 3 == 0 && c >= 2) dfs(v/3, c-2);  
        dfs(v-1, c+1);
    }
    public int solution(int n) {
        dfs(n-2, 2);
        return answer;
    }
}

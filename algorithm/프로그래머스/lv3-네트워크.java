import java.util.*;

class Solution {
    boolean[] visit;
    
    public void dfs(int target, int size, int[][] computers){
        for (int i=0; i<size; i++){
            if (computers[target][i] == 1 && visit[i] == false){
                visit[i] = true;
                dfs(i, size, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for (int i=0; i<n; i++){
            if (visit[i]) continue;
            dfs(i, n, computers);
            answer++;
        }
        
        return answer;
    }
}

import java.util.*;

class Solution {
    class Compare implements Comparable<Compare>{
        int from;
        int to;
        int cost;
        
        public Compare(int from, int to, int cost){
            super();
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Compare target){
            if (this.cost > target.cost){
                return 1;
            }else if (this.cost < target.cost){
                return -1;
            }
            return 0;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int[][] low = new int[n][n];
        boolean[] visit = new boolean[n];
        PriorityQueue<Compare> q = new PriorityQueue<Compare>();
        int answer = 0;
        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                low[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<costs.length; i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];            
            low[to][from] = cost;
            low[from][to] = cost;
        }
        for (int i=0; i<n; i++){
            if (low[0][i] != Integer.MAX_VALUE)
                q.offer(new Compare(0, i, low[0][i]));
        }
        
        visit[0] = true;
        while (!q.isEmpty()){            
            Compare node = q.poll();
            if (visit[node.to])
                continue;
            visit[node.to] = true;
            answer += node.cost;
            for (int i=0; i<n; i++){
                if (low[node.to][i] != Integer.MAX_VALUE && visit[i] == false){
                    q.offer(new Compare(node.to, i, low[node.to][i]));
                }
            }
        }
        return answer;
    }
}

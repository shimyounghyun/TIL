import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int count = 1;
        boolean[][] map = new boolean[n+1][n+1];
        boolean[] visit = new boolean[n+1];
        
        for (int i=0; i<edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            map[from][to] = true;
            map[to][from] = true;
        }
        visit[1] = true;
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> wait = new LinkedList<Integer>();
        for (int i=1; i<n+1; i++){
            if (map[1][i]){
                list.add(i);
                visit[i] = true;
                count++;
            }
        }
        while (count < n){
            answer = 0;
            while (!list.isEmpty()){
                int k = list.poll();
                for (int i=1; i<n+1; i++){
                    if (visit[i] == false && map[k][i]){
                        wait.add(i);
                        count++;
                        answer++;
                        visit[i] = true;
                    }
                }                
            }            
            while (!wait.isEmpty()){
                list.add(wait.poll());
            }
        }
        return answer;
    }
}

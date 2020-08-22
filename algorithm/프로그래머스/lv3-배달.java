import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N+1][N+1];
        
        for (int i=0; i<map.length; i++){
            for (int j=0; j<map.length; j++){
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i=0; i<road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];
            map[from][to] = Math.min(map[from][to], cost);
            map[to][from] = Math.min(map[to][from], cost);
        }
        
        for (int i=1; i<map.length; i++){
            for (int j=1; j<map.length; j++){
                for (int k=1; k<map.length; k++){
                    if (map[j][i] != Integer.MAX_VALUE 
                        && map[i][k] != Integer.MAX_VALUE)
                        map[j][k] = Math.min(map[j][k], map[j][i]+map[i][k]);
                }
            }
        }
        answer = 1;
        for (int i=2; i<map.length; i++)
            if (map[1][i] <= K)
                answer++;
        return answer;
    }
}

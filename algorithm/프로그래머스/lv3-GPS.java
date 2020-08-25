import java.util.*;

class Solution {
    boolean[][] map;
    int[][] dp;
    final int MAX = 1000000000;
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        map = new boolean[n+1][n+1];
        dp = new int[gps_log.length][n+1];
        for (int i=0; i<edge_list.length; i++){
            int from = edge_list[i][0];
            int to = edge_list[i][1];            
            map[from][to] = true;
            map[to][from] = true;
        }
        for (int i=1; i<map.length; i++){
            map[i][i] = true;
        }
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[i].length; j++){
                dp[i][j] = MAX;
            }
        }
        dp[0][gps_log[0]] = 0;
        for (int i=1; i<gps_log.length; i++){
            int num = gps_log[i];
            for (int j=1; j<dp[i].length; j++){
                if (dp[i-1][j] == MAX) continue;
                for (int q = 1; q<dp[i].length; q++){
                    if (map[j][q] == false) continue;
                    if (num == q){
                        dp[i][q] = Math.min(dp[i][q], dp[i-1][j]);
                    }else{
                        dp[i][q] = Math.min(dp[i][q], dp[i-1][j]+1);
                    }
                }
            }
        }
        if (dp[gps_log.length-1][gps_log[gps_log.length-1]] == MAX){
            return -1;
        }
        // print();
        return dp[gps_log.length-1][gps_log[gps_log.length-1]];
    }
    
    public void print(){
        for (int i=0; i<dp.length; i++){
            for (int j=1; j<dp[i].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}

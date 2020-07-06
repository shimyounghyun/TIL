import java.util.*;

class Solution {
    
    public void dfs (boolean[][] network, int[][] computers, int r, int c){
        ArrayList<Integer> list = new ArrayList<Integer>();
        network[r][c] = true;        
        for (int i=0; i<computers[c].length; i++){
            if (i == c)
                continue;
            if (computers[c][i] == 1 && network[c][i] == false){
                list.add(i);
                network[c][i] = true;
                network[i][c] = true;
            }
        }
        int m = 0;
        while (m < list.size()){
            int n = list.get(m);
            for(int i=0; i<computers[n].length; i++){
                if (computers[n][i] == 1 && network[n][i] == false){
                    list.add(i);
                    network[n][i] = true;
                    network[i][n] = true;
                }
            }
            m++;
        }
    }
    
    public int solution(int n, int[][] computers) {
        boolean[][] network = new boolean[n][n];
        
        int count = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (network[i][j])
                    continue;
                if (computers[i][j] == 1 && network[i][j] == false){
                    dfs(network, computers, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}

class Solution {
    public int solution(int n, int[][] r) {
        int answer = 0;
        int[][] map = new int[n][n];
        for (int i=0; i<r.length; i++){
            int from = r[i][0]-1;
            int to = r[i][1]-1;
            map[from][to] = 1;
            map[to][from] = -1;
        }        
        for (int k=0; k<n; k++){
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    if (map[i][k] != 0 && map[i][k] == map[k][j]){
                        map[i][j] = map[i][k];
                    }
                }
            }
        }        
        for (int i=0; i<n; i++){
            int count = 0;
            for (int j=0; j<n; j++){
                if (map[i][j] != 0){
                    count++;
                }
            }
            if (count == n-1){
                answer++;
            }
        }
        return answer;
    }
}

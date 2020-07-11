class Solution {
    public boolean check(int[][] p, int y, int x){
        for (int i=0; i<p.length; i++){
            if (p[i][0]-1 == x && p[i][1]-1 == y) return false;
        }
        return true;
    }
    public int solution(int m, int n, int[][] p) {
        int[][] map = new int[n][m];
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (check(p, i, j)){
                    if (i == 0 && j == 0){
                        map[0][0] = 1;
                    }else if (i == 0){
                        map[0][j] = map[0][j-1];
                    }else if (j == 0){
                        map[i][0]= map[i-1][0];
                    }else if (i != 0 && j != 0){
                        map[i][j] = (map[i-1][j] + map[i][j-1])%1000000007;
                    }   
                }
            }
        }        
        return map[n-1][m-1];
    }
}

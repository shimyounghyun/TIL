class Solution {
    int[] parent;
    
    int[] dirX = {0, 0, 1, -1};
    int[] dirY = {1, -1, 0, 0};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        parent = new int[row * col + 1];
        
        for (int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        
        for (int i=0;i <row; i++){
            for (int j=0; j<col; j++){
                if (board[i][j] == 'O'){
                    int o = i*col+j;
                    if (i == 0 || j == 0 || i == row-1 || j == col-1){
                        union(o, row * col);
                        continue;
                    }
                    for (int k=0; k<4; k++) {
                        if (i+dirY[k] < 0 || i+dirY[k]>=row || j+dirX[k] < 0 || j+dirX[k] >= col
                           || board[i+dirY[k]][j+dirX[k]] == 'X') continue;
                        union(o, (i+dirY[k])*col+j+dirX[k]);
                    }
                }
            }
        }
        
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (board[i][j] == 'O' && find(i*col+j) != find(row * col)) board[i][j] = 'X';
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) x = find(parent[x]);
        return parent[x];
    }
    
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY){
            if (rootX > rootY){
                parent[rootX] = rootY;
            }else{
                parent[rootY] = rootX;
            }
        }
    }
}

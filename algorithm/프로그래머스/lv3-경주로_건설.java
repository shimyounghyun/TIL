import java.util.*;

class Solution {
    public class Node{
        int curDir; // 위,아래,오른쪽,왼쪽
        int x;
        int y;
        int cost;
        public Node(int y, int x, int cost, int curDir){
            this.x=x;
            this.y=y;
            this.cost=cost;
            this.curDir=curDir;
        }
    }
    int[] dirY = {0, 0, -1, 1};
    int[] dirX = {1, -1, 0, 0};
    public int solution(int[][] board) {
        int answer = 0;
        LinkedList<Node> list = new LinkedList<>();
        int[][] result = new int[board.length][board.length];
        
        for (int i=0; i<result.length; i++){
            for (int j=0; j<result[0].length; j++){
                if (!(i == 0 && j == 0)){
                   result[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        list.add(new Node(0, 0, 0, -1));        
        while (!list.isEmpty()){
            Node n = list.poll();
            
            for (int d=0; d<4; d++){
                int move = getDir(n.x, n.y, n.x+dirX[d] ,n.y+dirY[d]);
                if (n.y+dirY[d] < 0 || n.y+dirY[d] >= board.length
                   || n.x+dirX[d] < 0 || n.x+dirX[d] >= board.length
                   || board[n.y+dirY[d]][n.x+dirX[d]] == 1)
                    continue;
                int cost = isCorner(n.curDir, move) ? n.cost+600 : n.cost+100;
                if (result[n.y+dirY[d]][n.x+dirX[d]] < cost)
                    continue;
                result[n.y+dirY[d]][n.x+dirX[d]] = cost;
                list.add(new Node(n.y+dirY[d], n.x+dirX[d], cost, move));
            }
        }
        return result[board.length-1][board.length-1];
    }
    
    public boolean isCorner(int prevD, int nextD){
        if ((prevD == 0 || prevD == 1) && (nextD == 2 || nextD == 3))
            return true;
        else if ((prevD == 2 || prevD == 3) && (nextD == 0 || nextD == 1))
            return true;
        return false;
    }
    
    public int getDir(int fromX, int fromY, int toX, int toY){
        if (fromX == toX && (fromY - toY) == 1) // 위
            return 0;
        else if (fromX == toX && (fromY - toY) == -1) // 아래
            return 1;
        else if (fromY == toY && (fromX - toX) == 1) // 오른쪽
            return 2;
        else
            return 3;
    }
}

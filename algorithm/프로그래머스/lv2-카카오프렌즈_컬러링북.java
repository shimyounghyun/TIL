import java.util.*;

class Solution {
    int[] dirX = {1,-1,0,0};
    int[] dirY = {0,0,1,-1};
    public class Node {
        int i;
        int j;
        public Node(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public int bfs(boolean[][] visit, int i, int j, int[][] picture){
        int num = picture[i][j];
        LinkedList<Node> list = new LinkedList<>();
        list.add(new Node(i,j));
        int answer = 0;
        visit[i][j] = true;
        while (!list.isEmpty()){
            Node n = list.poll();
            
            for (int k=0; k<4; k++){
                if (dirX[k]+n.j < 0 || dirX[k]+n.j >= picture[0].length
                   || dirY[k]+n.i < 0 || dirY[k]+n.i >= picture.length
                   || visit[dirY[k]+n.i][dirX[k]+n.j]
                   || picture[dirY[k]+n.i][dirX[k]+n.j] != num)
                    continue;
                list.add(new Node(dirY[k]+n.i, dirX[k]+n.j));
                visit[dirY[k]+n.i][dirX[k]+n.j] = true;
            }
            answer++;
        }
        return answer;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visit = new boolean[picture.length][picture[0].length];
        
        for (int i=0; i<picture.length; i++){
            for (int j=0; j<picture[i].length; j++){
                if (visit[i][j] == true || picture[i][j] == 0)
                    continue;
                int bfsCount = bfs(visit, i, j, picture);
                numberOfArea++;
                maxSizeOfOneArea = maxSizeOfOneArea < bfsCount ? bfsCount : maxSizeOfOneArea;
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

// [1, 1, 1, 0], 
// [1, 2, 2, 0], 
// [1, 0, 0, 1], 
// [0, 0, 0, 1], 
// [0, 0, 0, 3], 
// [0, 0, 0, 3]

// [1, 1, 1, 0], 
// [1, 1, 1, 0], 
// [0, 0, 0, 1], 
// [0, 0, 0, 1], 
// [0, 0, 0, 1], 
// [0, 0, 0, 1]

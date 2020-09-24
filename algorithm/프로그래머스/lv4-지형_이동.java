import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int solution(int[][] land, int height) {
        int answer = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[][] visit = new boolean[land.length][land[0].length];
        visit[0][0] = true;
        q.add(new Node(0, 0, 0));
        
        while (!q.isEmpty()){
            Node n = q.poll();
            
            if (visit[n.y][n.x] == false && n.dif > height) answer += n.dif;
            visit[n.y][n.x] = true;
            for (int i=0; i<4; i++){
                if (n.x + dx[i] < 0 || n.x + dx[i] >= land[0].length
                   || n.y + dy[i] < 0 || n.y + dy[i] >= land.length
                   || visit[n.y+dy[i]][n.x+dx[i]]) continue;
                int dif = Math.abs(land[n.y][n.x] - land[n.y+dy[i]][n.x+dx[i]]);
                q.add(new Node(dif, n.x + dx[i], n.y + dy[i]));
            }
        }
        return answer;
    }
    
    class Node implements Comparable<Node> {
        int dif;
        int y;
        int x;
        
        public Node (int dif, int x, int y){
            this.x=x;
            this.y=y;
            this.dif=dif;
        }
        
        public int compareTo(Node n){
            return Integer.compare(this.dif, n.dif);
        }
    }
}

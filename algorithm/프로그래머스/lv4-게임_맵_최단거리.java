import java.util.*;

class Solution {
    final int MAX = 100000000;
    int[][] map;
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int solution(int[][] maps) {
        int answer = 0;
        map = new int[maps.length][maps[0].length];
        int[][] distance = new int[map.length][map[0].length];
        for (int i=0; i<maps.length; i++){
            for (int j=0; j<maps[i].length; j++){
                if (maps[i][j] == 0)
                    map[i][j] = MAX;
                else
                    map[i][j] = 1;
                distance[i][j] = MAX;
            }
        }
        distance[0][0] = 0;
        boolean[][] visit = new boolean[maps.length][map[0].length];
        visit[0][0] = true;
        PriorityQueue<Node> list = new PriorityQueue<>();
        list.add(new Node(0,0,1));
        while (!list.isEmpty()){
            Node n = list.poll();
            int y = n.y;
            int x = n.x;
            if (y == maps.length-1 && x == maps[0].length-1) return n.order;
            visit[y][x] = true;
            for (int i=0; i<4; i++){
                if (n.x+dx[i] < 0 || n.x+dx[i] >= map[0].length
                   || n.y+dy[i] < 0 || n.y+dy[i] >= map.length
                   || map[n.y+dy[i]][n.x+dx[i]] >= MAX
                   || visit[n.y+dy[i]][n.x+dx[i]]
                   || distance[n.y+dy[i]][n.x+dx[i]] <= distance[y][x]+map[n.y+dy[i]][n.x+dx[i]]) continue;
                distance[n.y+dy[i]][n.x+dx[i]] = distance[y][x]+map[n.y+dy[i]][n.x+dx[i]];
                list.add(new Node(n.y+dy[i], n.x+dx[i], n.order+1));
            }
        }
        return -1;
    }
    
    public class Node implements Comparable<Node>{
        int y;
        int x;
        int order;
        
        public Node(int y, int x, int order){
            this.y= y;
            this.x=x;
            this.order=order;
        }
        
        public int compareTo(Node n){
            return Integer.compare(this.order, n.order);
        }
    }
    
    public void print(int[][] m){
        for (int i=0; i<m.length; i++)
            System.out.println(Arrays.toString(m[i]));
    }
}

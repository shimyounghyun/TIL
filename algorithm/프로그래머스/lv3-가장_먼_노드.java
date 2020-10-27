import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n+1];
        boolean[] visit = new boolean[n+1];
        int answer = 0;
        List<Integer>[] list = new List[n+1];
        for (int i=1; i<=n; i++)
            list[i] = new LinkedList<>();
        for (int i=0; i<edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        visit[1] = true;
        for(int i=0; i<list[1].size(); i++){
            q.add(new Node(list[1].get(i), 1));
            dist[list[1].get(i)] = 1;
        }
        int max = 0;
        while (!q.isEmpty()){
            Node node = q.poll();
            visit[node.num] = true;
            
            for(int i=0; i<list[node.num].size(); i++){
                int num = list[node.num].get(i);
                if (visit[num] || dist[num] != 0) continue;
                dist[num] = node.val +1;
                int count = dist[num];
                max = Math.max(max, count);
                q.add(new Node(num, count));
            }
        }
        
        for (int i=1; i<dist.length; i++)
            if (max == dist[i]) answer++;
        return answer;
    }
    
    public class Node implements Comparable<Node> {
        int num;
        int val;
        
        public Node(int num, int val){
            this.num = num;
            this.val = val;
        }
        
        public int compareTo(Node n){
            return Integer.compare(this.val, n.val);
        }
    }
}

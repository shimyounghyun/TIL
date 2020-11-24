import java.util.*;

class Solution {
    public List<Integer>[] list;
    public int solution(int n, int[][] edges) {
        int answer = 0;
        list = new ArrayList[n+1];
        for (int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }
        for (int i=0; i<edges.length; i++){
            int to = edges[i][0];
            int from = edges[i][1];
            list[to].add(from);
            list[from].add(to);
        }
        int[] d = bfs(1);
        int max = 0;
        int count = 0;
        int index = -1;
        for (int i : d) max = Math.max(i, max);
        for (int i=1; i<d.length; i++) if (max == d[i]) index = i;
        
        d = bfs(index);
        max = 0;
        int otherIndex = -1;
        for (int i : d) max = Math.max(i, max);
        for (int i=1; i<d.length; i++) if (max == d[i]){ count++; otherIndex = i;}
        if (count >= 2) return max;
        d = bfs(otherIndex);
        count = 0;
        for (int i : d) if (max == i) count++;
        if (count >= 2) return max;
        return max-1;
    }
    
    public int[] bfs(int root){
        boolean[] v = new boolean[list.length];
        int[] result = new int[list.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        v[root] = true;
        while (!q.isEmpty()){
            int n = q.poll();
            for (int i : list[n]){
                if (v[i]) continue;
                result[i] = result[n]+1;
                q.add(i);
                v[i] = true;
            }
        }
        return result;
    }
}

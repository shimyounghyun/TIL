import java.util.*;

public class Main{
    public static class Node implements Comparable<Node> {
        int v1;
        int v2;
        int cost;
        
        public Node(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        
        public int compareTo(Node n){
            return Integer.compare(this.cost, n.cost);
        }
        
    }
    static int[] parent;
    
    public static int find(int x){
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }
    
    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        
        if (x != y){
            if (x > y)
                parent[x] = y;
            else
                parent[y] = x;
            return true;
        }
        return false;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Node> list = new ArrayList<>();
        int v = sc.nextInt();
        int e = sc.nextInt();
        parent = new int[v+1];
        for (int i=1; i<=v; i++)
            parent[i] = i;
        for (int i=0; i<e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            list.add(new Node(v1, v2, cost));
        }
        Collections.sort(list);
        int sum = 0;
        for (Node n : list){
            if (union(n.v1, n.v2))
                sum+=n.cost;
        }
        System.out.println(sum);
    }
}

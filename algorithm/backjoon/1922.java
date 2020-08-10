import java.util.*;

public class Main{

public static class Node implements Comparable<Node>{
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

public static int find(int x, int[] parent){
    if (parent[x] == x)
        return x;
    else
        return parent[x] = find(parent[x], parent);
}

public static boolean union(int x, int y, int[] parent){
    x = find(x, parent);
    y = find(y, parent);
    
    if (x != y){
        parent[y] = x;
        return true;
    }
    return false;
}


public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int v = Integer.parseInt(sc.nextLine());
    int e = Integer.parseInt(sc.nextLine());
    List<Node> list = new ArrayList<>();
    int[] parent = new int[v+1];
    for (int i=1; i<=v; i++)
        parent[i] = i;
    for (int i=0; i<e; i++){
        String input = sc.nextLine();
        int v1 = Integer.parseInt(input.split(" ")[0]);
        int v2 = Integer.parseInt(input.split(" ")[1]);
        int cost = Integer.parseInt(input.split(" ")[2]);
        list.add(new Node(v1, v2, cost));
    }
    Collections.sort(list);
    
    int cost = 0;
    for (Node n : list){
        if (union(n.v1, n.v2, parent))
            cost += n.cost;
    }
    System.out.println(cost);
}
}

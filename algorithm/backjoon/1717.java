import java.util.*;

public class Main{
    public static int find(int x, int[] parent){
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x], parent);
    }
    
    public static void union(int x , int y, int[] parent){
        x = find(x,parent);
        y = find(y,parent);
        
        if (x != y){
            if (x > y)
                parent[x] = y;
            else
                parent[y] = x;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[] parent = new int[v+1];
        for (int i=1; i<=v; i++)
            parent[i] = i;
        
        for (int i=0; i<e; i++){
            int type = sc.nextInt();
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            if (type == 0){
                union(v1, v2, parent);
            }else{
                if (find(v1,parent) == find(v2,parent)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Node>[] list = new LinkedList[n+1];
        for (int i=0; i<n+1; i++)
            list[i] = new LinkedList();

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[from].add(new Node(val, to));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] result = new int[n+1];
        for (int i=1; i<n+1; i++)
            result[i] = 100000000;
        result[start] = 0;
        while (!q.isEmpty()){
            int index = q.poll();
            for (Node node : list[index]){
                if (result[node.index] > result[index]+node.val){
                    result[node.index] = result[index]+node.val;
                    q.add(node.index);
                }
            }
        }

        System.out.println(result[end]);
    }

    public static class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}

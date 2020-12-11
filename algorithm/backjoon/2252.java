import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken())+1;
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] list = new LinkedList[n];
        for (int i=0; i<n; i++){
            list[i] = new LinkedList();
        }

        int[] degree = new int[n];
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list[first].add(second);
            degree[second]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<list.length; i++){
            if (degree[i] == 0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            int index = q.poll();
            System.out.print(index+" ");
            for (int j : list[index]){
                if (--degree[j] == 0){
                    q.add(j);
                }
            }
        }
    }
}

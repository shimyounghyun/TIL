import java.util.*;
import java.io.*;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<t; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int r = Integer.parseInt(br.readLine()); 
        boolean[][] dp = new boolean[t][t];
        for (int i=0; i<t; i++){
            dp[i][i] = true;
        }
        
        for (int i=0; i<t-1; i++) {
            if (arr[i] == arr[i+1])
                dp[i][i+1] = true;
        }
        
        for (int i=2; i<t; i++){
            for (int j=0; j<t; j++){
                if (j+i < t && arr[j] == arr[j+i] &&
                   dp[j+1][j+i-1])
                    dp[j][j+i] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            
            if (dp[start][end])
                sb.append("1\n");
            else
                sb.append("0\n");
        }
        System.out.println(sb);
    }
}

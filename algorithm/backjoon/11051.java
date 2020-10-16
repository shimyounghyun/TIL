import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        if (n == 0){
            System.out.println(1);
            return;
        }
        int[][] dp = new int[1001][1001];
        for (int i=1; i<=1000; i++){
            for (int j=0; j<=i; j++){
                if (j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%10007;
            }
        }
        System.out.println(dp[n][r]);
    }
}



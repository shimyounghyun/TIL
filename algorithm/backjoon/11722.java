import java.util.*;

//6
//10 30 10 20 20 10
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = new int[size];
        String[] input = sc.nextLine().split(" ");
        int[] dp = new int[input.length];
        for (int i=0; i<input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        for (int i=0; i<input.length; i++){
            dp[i] = 1;
            for (int j=0; j<=i; j++){
                if (arr[i] < arr[j]){
                   dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 0;
        for (int i=0; i<dp.length; i++)
            max = Math.max(max, dp[i]);
        System.out.println(max);
    }
}

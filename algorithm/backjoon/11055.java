import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = new int[size];
        String[] input = sc.nextLine().split(" ");
        for (int i=0; i<input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int[] dp = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            dp[i] = arr[i];
            for (int j=0; j<=i; j++){
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
            }
        }
        int max = 0;
        for (int i=0; i<dp.length; i++)
            max = Math.max(dp[i], max);
        System.out.println(max);
    }
}

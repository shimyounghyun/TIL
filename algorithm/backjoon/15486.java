import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		int a = Integer.parseInt(sc.nextLine());
		
		int[] dp = new int[a+1];
		int dap = 0;
		for (int i=0; i<a; i++) {
			String[] info = sc.nextLine().split(" ");
			int t = Integer.parseInt(info[0]);
			int c = Integer.parseInt(info[1]);			
			dap = Math.max(dap, dp[i]);
			if (i+t < dp.length) {
				dp[i+t] = Math.max(dp[i+t], dap+c);
			}
		}
		int max = 0;
		for (int i=0; i<dp.length; i++)
			max = Math.max(max, dp[i]);
		System.out.println(max);
	}
}



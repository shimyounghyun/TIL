import java.util.*;

public class Main{
    public static void main(String[] args) {
		long[] arr = new long[1000001];
		for (int i=2,j=1; i<=1000000; i*=2) {
			arr[i] = j;
			j++;
		}
		for (int i=3; i<=1000000; i++) {
			if (arr[i] != 0) continue;
			long num = (long)i;
			int count = 0;
			while (num > 1) {
				if (num % 2 == 0) {
					num /= 2;
				}else {
					num = num * 3 + 1;
				}
				count++;
				if (num <= 1000000 && arr[(int)num] != 0) break;
			}
			arr[i] = count+arr[(int)num];
		}
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(		sc.nextLine());
		System.out.println(arr[n]+1);
	}
}

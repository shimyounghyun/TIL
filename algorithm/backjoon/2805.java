import java.util.*;

public class Main {
    public static int solution(int n, int m, int[] arr){
        int start = 1;
        int end = 1000000001;
        int mid = (start+end)/2;
        while (start <= end){
            long total = 0;
            for (int i=0; i<arr.length; i++){
                if (mid < arr[i]) total += (long)arr[i] - mid;
            }
            if (total > (long)m){
                start = mid + 1;
            }else if (total < (long)m){
                end = mid - 1;
            }else {
                return mid;
            }
            mid = (start+end)/2;
        }
        return mid;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] info = sc.nextLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        String[] strArr = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        System.out.println(solution(n, m, arr));
    }
}

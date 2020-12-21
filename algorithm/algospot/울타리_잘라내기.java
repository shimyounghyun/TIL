import java.util.*;

public class Main {
    static int[][] map;
    static int index = -1;
    public static void main(String[] args) throws Exception{
//        String[] testCase = {"01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"};
//        String[] testCase = {"04/01 1 40000","05/01 5 20000","08/31 4 10000","11/11 0 -45000"};
//        int[] arr = {7, 1, 5, 9, 6, 7, 3};
//        int[] arr = {1, 4, 4, 4, 4, 1, 1};
//        int[] arr = {1, 8, 2, 2};

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i=0; i<n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            int[] arr = new int[m];
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }
            System.out.println(solution(arr, 0, arr.length-1));
        }
    }

    public static int getDay(int month, int date){
        int[] sum = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        return sum[month-1]+date;
    }

    public static int solution(int[] arr, int left, int right){
        if (left == right) return arr[left];
        int mid = (left+right)/2;
        int ret = Math.max(solution(arr, left, mid), solution(arr, mid+1, right));
        int height = Math.min(arr[mid], arr[mid+1]);
        ret = Math.max(ret, height*2);

        int l = mid;
        int r = mid+1;
        while (left <= l && r <= right){
            if (right == r || (l-1 >= left && arr[l-1] > arr[r+1])){
                l--;
                if (l < left) break;
                height = Math.min(height, arr[l]);
            }else{
                r++;
                if (r > right) break;
                height = Math.min(height, arr[r]);
            }
            ret = Math.max(ret, (r-l+1)*height);
        }
        return ret;
    }
}

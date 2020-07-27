import java.util.*;
import java.util.stream.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i=0; i<t; i++){ 
            String info[] = sc.nextLine().split(" ");            
            int[] arr = IntStream.range(1,info.length)
                                .map(index -> Integer.parseInt(info[index]))
                                .toArray();
            int start = 0;
            int end = arr.length-1;
            int mid = (start+end)/2;
            int sum = 0;
            for (int j =0; j<arr.length; j++)
                sum += arr[j];
            double result = (double)sum/(double)arr.length;
            int index = 0;
            Arrays.sort(arr);
            while (start <= end){
                if ((double)arr[mid] <= result){
                    start = mid + 1;
                }else if((double)arr[mid] > result){
                    end = mid - 1;
                    index = mid;
                }
                                mid = (start+end)/2;
            }
            if (arr[index] > result){
                System.out.printf("%.3f%%\n", (double)(arr.length-index)/(double)arr.length*(double)100);
            }else{
                System.out.println("0.000%");
            }
        }
    }
}

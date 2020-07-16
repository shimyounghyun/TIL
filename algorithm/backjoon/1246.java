import java.util.*;
public class Main{
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] arr = new int[Integer.parseInt(input.split(" ")[1])];
        int max_count = Integer.parseInt(input.split(" ")[0]);
        
        for (int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        Arrays.sort(arr);
        int max = 0;
        int cost = 0;
        for (int i=0; i<arr.length; i++){
            int c = max_count < arr.length-i ? max_count : arr.length-i;
            if (max < arr[i]*c ){
                max = arr[i]*c;
                cost = arr[i];
            }
        }
       System.out.println(cost+" "+max);
	}
}

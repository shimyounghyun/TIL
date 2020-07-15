import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        int a = Integer.parseInt(input.split(" ")[0]);
        int b = Integer.parseInt(input.split(" ")[1]);
        int v = Integer.parseInt(input.split(" ")[2]);
        
        int start = 1;
        int end = v%(a-b) > 0 ? v/(a-b)+1 : v/(a-b);
        int mid = (start + end)/2;
        int answer = 1;
        while (start <= end){            
            if ((a-b)*(mid-1)+a >= v){
                end = mid - 1;
                answer = mid;
            }else{
                start = mid + 1;                
            }
            mid = (start+end)/2;
        }
        System.out.print(answer);
	}
}

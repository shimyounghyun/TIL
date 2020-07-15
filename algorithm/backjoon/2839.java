import java.util.*;
public class Main{
public static int sol(int n){
        int five = n/5;
        int three = 0;
        
        while (five >= 0){
            int sum = n-5*five;
            three = sum/3;
            sum = sum - three*3;
            if (sum == 0){
                return five+three;
            }
            five--;
        }
        return -1;
    }
	public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
        System.out.println(sol(Integer.parseInt(sc.nextLine())));
	}
}

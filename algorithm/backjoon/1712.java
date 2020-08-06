import java.util.*;

public class Main{
    	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]); 

        if (b >= c){
            System.out.println(-1);
            return;
        }
        System.out.println(a/(c-b)+1);
	}
}

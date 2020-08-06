import java.util.*;
public class Main{
public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         String[] input = sc.nextLine().split(" ");
        
         int a = Integer.parseInt(input[0]);
         int b = Integer.parseInt(input[1]);
         int c = Integer.parseInt(input[2]);
         int x = Integer.parseInt(input[3]);
         int y = Integer.parseInt(input[4]);
        int cost = 0;

        cost = (c*2)*Math.max(x,y);
        cost = Math.min(cost, x*a+y*b);
        cost = Math.min(cost, Math.min(x,y)*(c*2)+(x-Math.min(x,y))*a+(y-Math.min(x,y))*b);
        System.out.println(cost);
	}
}

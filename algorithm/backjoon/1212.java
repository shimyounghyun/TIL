import java.util.*;

public class Main{
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      String input = sc.nextLine();
      String[] arr = {"000","001","010","011","100","101","110","111"};
        for (int i=0; i<input.length(); i++){
            Character index = input.charAt(i);
            String answer = "";
            if (i == 0 && index == '0'){
                answer = "0";
            }else{
                answer += arr[index-'0'];
            }
            if (i == 0 && index >= '1' && index <= '3'){
                String[] nonZero = {"1","10","11"};
                answer = nonZero[(index-'0')-1];
            }
            System.out.print(answer);
        }
	}
}

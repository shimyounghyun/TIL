import java.util.*;

public class Main{
public static boolean isGrouped(String input){
        boolean[] save = new boolean[26];
        Character prev = '1';
        
        for (int i=0; i<input.length(); i++){
            if (prev == input.charAt(i))
                continue;
            if (save[input.charAt(i)-'a']){
                return false;
            }
            save[input.charAt(i)-'a'] = true;
            prev = input.charAt(i);
        }
        return true;
    }
    
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i=0; i<t; i++){
            if (isGrouped(sc.nextLine())){
                count++;
            }
        }
        System.out.println(count);
	}
                }

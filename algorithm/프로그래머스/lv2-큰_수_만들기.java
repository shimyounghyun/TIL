import java.util.*;

class Solution {
    // 987654321 : 98765
    // 123456789 : 12345
    // 9812    
    public String solution(String number, int k) { 
        StringBuilder answer = new StringBuilder("");
        int count = number.length()-k; // 3 - 2 = 1
        
        for (int i=0; i<number.length(); i++){
            Character max = number.charAt(i);
            int index = i;
            if (count > 0){
                for (int j=i; j<number.length()-count+1; j++){
                    if (max < number.charAt(j)){
                        max = number.charAt(j);
                        index = j;
                    }
                }
            
                answer.append(max);
                i = index;
                count--;
            }
        }
        return answer.toString();
    }
}

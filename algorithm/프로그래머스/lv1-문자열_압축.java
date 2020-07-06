import java.util.*;

class Solution {
    
    public int solution(String s) {
        int length = s.length();
        int answer = Integer.MAX_VALUE;
        
        if (s.length() == 1)
            return 1;
        for (int i = 1; i<= length/2; i++){
            String substring = s.substring(0, i);
            String result = "";
            int count=1;
            for (int j=i; j<length; j+=i){
                int lastIndex = j+i > length ? length : j+i;
                String target = s.substring(j,lastIndex);
                if (target.equals(substring)){
                    count++;
                }else{
                    if (count > 1){
                        result += count + substring;
                    }else{
                        result += substring;
                    }
                    count=1;
                    substring = target;
                }
            }
            if (count > 1){
                result += count + substring;
            }else{
                result += substring;
            }
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}

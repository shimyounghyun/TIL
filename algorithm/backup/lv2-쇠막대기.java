import java.util.*;

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        LinkedList<Integer> level = new LinkedList<>();
        
        for (int i=0; i<arrangement.length(); i++){
            Character c = arrangement.charAt(i);
            
            if (arrangement.startsWith("()",i)){
                if (!level.isEmpty())
                    level.push(level.poll()+1);
                i++;
            }else if(c == '('){
                level.push(0);
            }else if (c == ')'){
                int count = level.poll();
                answer += count+1;
                if (!level.isEmpty())
                    level.push(level.poll()+count);
            }
        }        
        return answer;
    }
}

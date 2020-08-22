import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        LinkedList<Character> list = new LinkedList<>();
        
        for (int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            
            if (c == '('){
                list.add('(');
            }else{
                if (list.size() > 0){
                    list.poll();
                }else{
                    return false;
                }
            }
        }
        return list.size() == 0;
    }
}

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++){
            char current = s.charAt(i);
            if (stack.isEmpty()){
                stack.add(current);
            }else{
                char prev = stack.pop();
                if (current != prev){
                    stack.add(prev);
                    stack.add(current);
                }
            }
        }
        return stack.size() == 0 ? 1 : 0;
    }
    
}

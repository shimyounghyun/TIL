import java.util.*;

class Solution {
    public String decodeString(String s) {
        LinkedList<String> wList = new LinkedList<>();
        LinkedList<Integer> cList = new LinkedList<>();
        String stored = "";
        String answer = "";
        
        for (int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            
            if (Character.isDigit(c)){
                stored += c;
            }else if (c == '['){
                int count = Integer.parseInt(stored); 
                cList.push(count);
                wList.push("");
                stored = "";
            }else if (Character.isAlphabetic(c)){
                if (wList.size() > 0){
                    wList.push(wList.poll()+c);
                }else{
                    answer += c;
                }
                stored = "";
            }else if (c == ']'){
                int m = cList.poll();
                String n = wList.poll();
                String r = "";
                for (int k=0; k<m; k++){
                    r += n;
                }
                if (wList.size() > 0){
                    wList.push(wList.poll()+r);
                }else{
                    answer += r;
                }
            }
        }
        return answer;
    }
}

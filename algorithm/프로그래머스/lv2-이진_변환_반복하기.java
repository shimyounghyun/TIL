import java.util.*;

class Solution {
    int[] answer = new int[2];
    public int[] solution(String s) {
        
        while (!s.equals("1")){
            int length = cut(s);
            s = get(length);
            answer[0]++;
        }
        return answer;
    }
    
    public int cut(String s){
        int r = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '0') answer[1]++;
            else r++;
        }
        return r;
    }
    
    public String get(int l){
        String a = "";
        
        while (l > 0 ){
            a = l%2 + a;
            l /= 2;
        }
        return a;
    }
    
}

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(to3(n));
        return to10(sb.reverse().toString());
    }
    
    public String to3(int n){
        String r = "";
        while (n > 0){
            r = n%3 + r;
            n /= 3; 
        }
        return r;
    }
    
    public int to10(String n){
        int r = 0;
        for (int i=0; i<n.length(); i++){
            int num = n.charAt(i)-'0';
            r += (int)Math.pow(3,n.length()-(i+1))*num;
        }
        return r;
    }
}

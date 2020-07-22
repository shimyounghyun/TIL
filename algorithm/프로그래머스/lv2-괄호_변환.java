import java.util.*;

class Solution {
    public String solution(String p) {
        if (isCorrected(p))
            return p;
        return builder(p);
    }
    
    public String builder(String p){
        if (p.equals(""))
            return "";
        String u = "";
        String v = "";
        
        for (int i=0; i<p.length(); i++){
            String substring = p.substring(0,i+1);
            if (isBalanced(substring)){
                u = substring;
                if (i+1 == p.length()){
                    v = "";
                }else{
                    v = p.substring(i+1, p.length());
                }
                break;
            }
        }
        if (isCorrected(u)){
            return u + builder(v);
        }
        u = u.substring(1, u.length()-1);
        String reverseU = "";
        for (int i=0; i<u.length(); i++){
            if (u.charAt(i) == '('){
                reverseU += ")";
            }else{
                reverseU += "(";
            }
        }
        return "("+builder(v)+")"+reverseU;
    }
    
    public boolean isBalanced(String p){
        int left = 0;
        int right = 0;
        
        for (int i=0; i<p.length(); i++){
            if (p.charAt(i) == '('){
                left++;
            }else if(p.charAt(i) == ')'){
                right++;
            }
        }
        return left == right;
    }
    
    public boolean isCorrected(String p){
        int save = 0;
        for (int i=0; i<p.length(); i++){
            Character c = p.charAt(i);
            if (c == '('){
                save++;
            }else if(c == ')' && save == 0){
                return false;
            }else{
                save--;
            }
        }
        return save == 0;
    }
}

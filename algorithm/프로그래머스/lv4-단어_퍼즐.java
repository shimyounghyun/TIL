import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        
        boolean[] check = new boolean[t.length()+1];
        int size = t.length();
        int[] dp = new int[t.length()+1];
        check[0] = true;
        
        for (int i=0; i<size; i++){
            if (check[i] == false) continue;
            
            for (String str : strs){
                if (t.startsWith(str, i)){
                    int l = i+str.length();
                    check[l] = true;
                    dp[l] = dp[l] > 0 && dp[i]+1 > dp[l] ? dp[l] : dp[i]+1;
                }
            }
        }
        
        return check[size] ? dp[size] : -1;
    }
}

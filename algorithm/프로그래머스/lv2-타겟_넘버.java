import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] n, int t, int index, int sum){
        if (index == n.length){
            if (sum == t)
                return 1;
            return 0;
        }        
        return dfs(n, t, index+1, sum+n[index]) + dfs(n, t, index+1, sum-n[index]);
    }
}

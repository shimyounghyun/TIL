import java.util.*;

class Solution {
    int[] left;
    int[] right;
    int[][] memo;
    
    public int backtracking(int l, int r) {
        if (l == left.length || r == right.length){
            return 0;
        }
        if (memo[l][r] != -1)
            return memo[l][r];
        if (left[l] > right[r]){
            int sum = backtracking(l,r+1)+right[r];
            memo[l][r]=sum;
            return sum;
        }else{
            int sum = Math.max(backtracking(l+1,r+1), backtracking(l+1,r));
            memo[l][r] = sum;
            return sum;
        }
    }
    
    public int solution(int[] l, int[] r) {
        left = l;
        right = r;
        memo = new int[l.length][r.length];
        
        for (int i=0; i<l.length; i++){
            for (int j=0; j<l.length; j++){
                memo[i][j]=-1;
            }
        }
        return backtracking(0, 0);
    }
}

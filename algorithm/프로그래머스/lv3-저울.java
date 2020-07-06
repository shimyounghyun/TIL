import java.util.*;

class Solution {
    public int solution(int[] w) {
        int answer = 0;
        int max = 1;
        Arrays.sort(w);
        if (w[0] != 1)
            return 1;
        for(int i=1; i<w.length; i++){
            if (w[i] <= max+1){
                max += w[i];
            }else{
                return max+1;
            }
        }
        return max+1;
    }
}

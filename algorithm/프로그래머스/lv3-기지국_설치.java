import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        for (int i=0; i<stations.length; i++){
            int position = stations[i];
            if ((position-w) - start > 0){
                int range = (position-w) - start;
                int d = w*2+1;
                answer += range%d == 0 ? range/d : (range/d) + 1;
            }
            start = position+w+1;
        }
        if (n - start+1 > 0){
            int range = n - start+1;
            int d = w*2+1;
            answer += range%d == 0 ? range/d : (range/d) + 1;
        }
        return answer;
    }
}

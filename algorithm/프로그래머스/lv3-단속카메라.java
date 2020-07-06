import java.util.*;

class Solution { 
    public int solution(int[][] r) {
        int answer = 1;
        Arrays.sort(r, Comparator.comparingInt(o1 -> o1[0]));
        int temp = r[0][1];
        for (int i=1; i<r.length; i++){
            if (r[i][1] < temp ){
                temp = r[i][1];
            }else if (temp < r[i][0]){
                temp = r[i][1];
                answer++;
            }
        }
        return answer;
    }
}

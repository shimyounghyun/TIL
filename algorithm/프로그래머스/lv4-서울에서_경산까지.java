import java.util.*;

class Solution {
    public int solution(int K, int[][] travel) {
        int[][] answer = new int[travel.length][K+1];
        
        answer[0][travel[0][0]] = travel[0][1];
        answer[0][travel[0][2]] = Math.max(answer[0][travel[0][2]], travel[0][3]);
        
        for (int i=1; i<travel.length; i++){
            for (int j=0; j<K+1; j++){
                if (answer[i-1][j] == 0)
                    continue;
                if (j+travel[i][0] <= K){
                    answer[i][j+travel[i][0]] = Math.max(answer[i-1][j]+travel[i][1], answer[i][j+travel[i][0]]);
                }
                if (j+travel[i][2] <= K){
                    answer[i][j+travel[i][2]] = Math.max(answer[i-1][j]+travel[i][3],answer[i][j+travel[i][2]]);
                }
            }
        }
        int result = 0;
        for (int i=0; i<K+1; i++){
            result = Math.max(result, answer[travel.length-1][i]);
        }
        return result;
    }
}

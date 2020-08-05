import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0; i<n; i++){
            int r = (arr1[i] | arr2[i]);
            String line = "";
            for (int j=0; j<n; j++){
                if ((r&(1 << j)) == (1 << j)){
                    line = "#" + line;
                }else{
                    line = " "+ line;
                }
            }
            answer[i] = line;
        }
        return answer;
    }
}

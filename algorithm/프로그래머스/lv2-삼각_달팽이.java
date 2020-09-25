import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int y=-1;
        int x=0;
        int num = 1;
        for (int i=0; i<n; i++){
            for (int j=0; j<(n-i); j++){
                if (i % 3 == 0){
                    y++;
                }else if (i % 3 == 1){
                    x++;
                }else{
                    y--;
                    x--;
                }
                map[y][x] = num;
                num++;
            }
        }
        
        int[] answer = new int[num-1];
        int index = 0;
        for (int i=0; i<map.length; i++){
            for (int j=0; j<map[i].length; j++){
                if (map[i][j] == 0) break;
                answer[index] = map[i][j];
                index++;
            }
        }
        return answer;
    }
}

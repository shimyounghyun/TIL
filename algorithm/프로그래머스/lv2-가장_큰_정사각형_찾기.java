import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] ref = new int[board.length+1][board[0].length+1];
        for (int i=1; i<ref.length; i++){
            for (int j=1; j<ref[0].length; j++){
                ref[i][j] = board[i-1][j-1];
            }
        }
        
        for (int i=1; i<ref.length; i++){
            for (int j=1; j<ref[0].length; j++){
                int a = ref[i-1][j-1];
                int b = ref[i-1][j];
                int c = ref[i][j-1];
                if (ref[i][j] != 0)
                    ref[i][j] = Math.min(Math.min(a,b),c)+1;
                answer = Math.max(answer, ref[i][j]);
            }
        }
        return answer*answer;
    }
}

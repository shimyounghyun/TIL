import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] countArr = new int[board.length];
        LinkedList<Integer> stack = new LinkedList<>();
        Arrays.fill(countArr, -1);
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board.length; j++){
                if (board[i][j] != 0 && countArr[j] == -1){
                    countArr[j] = i;
                    // System.out.println(board.length-i);
                }
            }
        }
        for (int m=0; m<moves.length; m++){
            int j = moves[m]-1;
            int i = countArr[j];
            // System.out.println(board[i][j]);
            if (i < board.length){
                countArr[j]=i+1;
                if (stack.size() > 0 && stack.peek() == board[i][j]){
                    stack.poll();
                    answer+=2;
                }else if(board[i][j] != 0){
                    stack.push(board[i][j]);
                }
            }
        }
        return answer;
    }
}

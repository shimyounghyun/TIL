import java.util.*;

class Solution {
    int[][] board;
    Set<String> ref = new HashSet<>();
    
    public boolean is2x3(int h, int w){
        String result = "";
        boolean s = true;
        Set<Integer> check = new HashSet<Integer>();
        for (int i=0; i<3; i++){
            for (int j=0; j<2; j++){
                int n = board[i+h][j+w];
                if (n == 0){
                    for (int k=0; k<h; k++){
                        if (board[k][j+w] != 0)
                            s = false;
                    }
                }else{
                    check.add(n);
                    result += i+""+j;
                }
            }
        }
        if (ref.contains(result) && s && check.size() == 1){
            for (int i=0; i<3; i++){
                for (int j=0; j<2; j++){
                    board[i+h][j+w]=0;
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean is3x2( int h, int w){
        String result = "";
        boolean s = true;
        Set<Integer> check = new HashSet<Integer>();
        for (int i=0; i<2; i++){
            for (int j=0; j<3; j++){
                int n = board[i+h][j+w];
                if (n == 0){
                    for (int k=0; k<h; k++){
                        if (board[k][j+w] != 0)
                            s = false;
                    }
                }else{
                    check.add(n);
                    result += i+""+j;
                }
            }
        }
        if (ref.contains(result) && s && check.size() == 1){
            for (int i=0; i<2; i++){
                for (int j=0; j<3; j++){
                    board[i+h][j+w]=0;
                }
            }
            return true;
        }
        return false;
    }
    
    public void refInit(){
        ref.add("00101112"); // 1-3
        ref.add("01112021"); // 1-4
        
        ref.add("00102021"); // 2-2
        ref.add("02101112"); // 2-3
        
        ref.add("01101112"); // 3-1
    }
    
    public int solution(int[][] board) {
        this.board = board;
        int length = board.length;
        int answer=0;
        refInit();
        
        for (int i=0; i<length; ++i){
            for (int j=0; j<length; ++j){
                boolean has = false;
                // 2x3 2개
                if (j < length-1 && i < length-2 && is2x3(i, j)){
                    has = true;
                    answer++;
                }
                // 3x2 3개
                if (j < length-2 && i < length-1 && is3x2(i, j)){
                    has = true;
                    answer++;
                };
                if (has)
                    j=-1;
            }
        }
        return answer;
    }
}

// [
//      [0,0,0,0,0,0,0]
//     ,[0,0,0,0,0,0,0]
//     ,[0,0,4,3,0,0,0]
//     ,[4,4,4,3,0,0,0]
//     ,[1,2,3,3,0,0,0]
//     ,[1,2,2,2,0,0,0]
//     ,[1,1,0,0,0,0,0]
// ]

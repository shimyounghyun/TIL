import java.util.*;

class Solution {
    int[] dirY = {1,0, -1, 0};
    int[] dirX = {0, 1, 0, -1};
    public boolean sol(String[] board, int i, int j){
        Character target = board[i].charAt(j);
        
        for (int k=0; k<4; k++){
            if (dirY[k]+i < 0 || dirY[k]+i >= board.length
               || dirX[k]+j < 0 || dirX[k]+j >= board[0].length()
               || board[dirY[k]+i].charAt(dirX[k]+j) == '*')
                continue;
            if (target == board[dirY[k]+i].charAt(dirX[k]+j)){
                board[i] = board[i].replace(target+"",".");
                board[dirY[k]+i] = board[dirY[k]+i].replace(target+"",".");
                return true;
            }
            if (board[dirY[k]+i].charAt(dirX[k]+j) == '.'){
                int temp_i = dirY[k]+i;
                int temp_j = dirX[k]+j;
                while (
                    temp_i >= 0 && temp_i < board.length
                    && temp_j >=0 && temp_j < board[0].length()
                    && board[temp_i].charAt(temp_j) == '.'
                ){
                    for (int d=0; d<4; d++){
                        if ((d+2)%4 == k || dirY[d]+temp_i < 0 
                            || dirY[d]+temp_i >= board.length
                           || dirX[d]+temp_j < 0 || dirX[d]+temp_j >= board[0].length()
                           || board[dirY[d]+temp_i].charAt(dirX[d]+temp_j) == '*')
                            continue;
                        if (target == board[dirY[d]+temp_i].charAt(dirX[d]+temp_j)){
                            board[i] = board[i].replace(target+"",".");
                            board[dirY[d]+temp_i] = 
                                board[dirY[d]+temp_i].replace(target+"",".");
                            return true;
                        }
                        
                        if (board[dirY[d]+temp_i].charAt(dirX[d]+temp_j) == '.'){
                            int straightY = dirY[d]+temp_i;
                            int straightJ = dirX[d]+temp_j;
                            while (straightY >= 0 && straightY < board.length
                                  && straightJ >= 0 && straightJ < board[0].length()
                                  && board[straightY].charAt(straightJ) == '.'){
                                if (straightY + dirY[d] < 0 
                                    || straightY + dirY[d] >= board.length
                                    || straightJ + dirX[d] < 0 
                                    || straightJ + dirX[d] >= board[0].length()
                                   )
                                    break;
                                if (board[straightY + dirY[d]].charAt(straightJ + dirX[d])
                                   == target){
                                    board[straightY + dirY[d]] = board[straightY + dirY[d]].replace(target+"",".");
                                    board[i] = board[i].replace(target+"",".");
                                    return true;
                                }
                                straightY += dirY[d];
                                straightJ += dirX[d];
                            }
                        }
                    }
                    temp_i += dirY[k];
                    temp_j += dirX[k];
                }
            }
        }
        return false;
    }
    
    public class Order implements Comparable<Order>{
        int i;
        int j;
        Character c;
        
        public Order(int i, int j, Character c){
            this.i=i;
            this.j=j;
            this.c=c;
        }
        
        public int compareTo(Order o){
            return this.c.compareTo(o.c);
        }
    }
    public String solution(int m, int n, String[] board) {
        String answer = "";
        List<Order> list = new ArrayList<>();
        Set<Character> check = new HashSet<>();
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){                
                if (board[i].charAt(j) == '*' || board[i].charAt(j) == '.')
                    continue;
                if (check.add(board[i].charAt(j))){
                    list.add(new Order(i, j, board[i].charAt(j)));
                }
            }
        }
        Collections.sort(list);
        LinkedList<Integer> complete = new LinkedList<>();
        
        for (int i=0; i<list.size(); i++){
            if (complete.contains(i))
                continue;
            Order o = list.get(i);
            if (sol(board, o.i, o.j)){
                answer += o.c;
                complete.add(i);
                // print(board);
                // System.out.println(complete.size());
                i = -1;
            }
        }
        
        if (list.size() != complete.size())
            answer = "IMPOSSIBLE";
        return answer;
    }
    
    public void print(String[] board){
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length(); j++){
                System.out.print(board[i].charAt(j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

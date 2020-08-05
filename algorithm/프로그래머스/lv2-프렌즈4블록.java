import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int[][] map = new int[m][n];

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (board[i].charAt(j) >= 'A' && board[i].charAt(j) <= 'Z')
                    map[i][j] = board[i].charAt(j);
                else
                    map[i][j] = 0;
            }
        }
        answer += remove4Block(map);
        while (isDownBlock(map)){
            answer += remove4Block(map);
        }
        return answer;
    }

    public int remove4Block(int[][] map){
        Set<String> set = new HashSet<>();
        for (int i=0; i<map.length-1; i++){
            for (int j=0; j<map[i].length-1; j++){
                int target = map[i][j];
                if (target != 0
                    && map[i][j+1] == target 
                    && map[i+1][j+1] == target
                   && map[i+1][j] == target){
                    set.add(i+","+j);
                    set.add((i+1)+","+j);
                    set.add(i+","+(j+1));
                    set.add((i+1)+","+(j+1));
                }
            }
        }

        for (String info : set){
            int i = Integer.parseInt(info.split(",")[0]);
            int j = Integer.parseInt(info.split(",")[1]);
            map[i][j] = 0;
        }
        return set.size();
    }

    public boolean isDownBlock(int[][] map){
        boolean result = false;
        for (int i=1; i<map.length; i++){
            for (int j=0; j<map[i].length; j++){
                if (map[i][j] == 0 && map[i-1][j] != 0){
                    int k=i;
                    while (k >= 1 && map[k-1][j] != 0){
                        map[k][j] = map[k-1][j];
                        map[k-1][j] = 0;
                        k--;
                    }
                    result = true;
                }
            }
        }
        return result;
    }
}

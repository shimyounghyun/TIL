import java.util.*;

class Solution {
    int[][] map;
    boolean[][] visit;
    int[] result = new int[2];
    public int[] solution(int[][] arr) {
        map = arr;
        checkArea(0, 0, arr[0].length);
        return result;
    }
    // 0 0 0 0 
    public void checkArea(int py, int px, int size){
        if (isSame(py, px, size)){
            result[map[py][px]]++;
            // System.out.println(py+" "+px);
        }else{
            checkArea(py, px, size/2);
            checkArea(py+size/2, px, size/2);
            checkArea(py, px+size/2, size/2);
            checkArea(py+size/2, px+size/2, size/2);
        }
    }
    
    public boolean isSame(int py, int px, int size){
        for (int i=py; i<py+size; i++){
            for (int j=px; j<px+size; j++){
                if (map[i][j] != map[py][px]) return false;
            }
        }
        return true;
    }
}

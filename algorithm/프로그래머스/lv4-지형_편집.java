import java.util.*;
public class Solution {
    public long solution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;
        if (land.length == 1) return 0;
        
        int start = 1;
        int end = 1000000000;
        int mid = (start + end) / 2;
        while (start <= end){
            
            long up = getCost(mid, land, P, Q);
            long down = getCost(mid-1, land, P, Q);
            if (up >= down){
                end = mid - 1;
                answer = Math.min(answer, down);
            }else{
                start = mid + 1;
                answer = Math.min(answer, up);
            }
            mid = (start + end) / 2;
        }
        return answer;
    }
    
    public long getCost(int mid, int[][] land, int P, int Q){
        long up = 0;
        long down = 0;
        for (int i=0; i<land.length; i++){
            for (int j=0; j<land[i].length; j++){
                if (land[i][j] > mid){
                    up += (long)land[i][j] - (long)mid;
                }else if (land[i][j] < mid){
                    down += (long)mid - (long)land[i][j];
                }
            }
        }
        up = up * (long)Q;
        down = down * (long)P;
        return up + down;
    }
}

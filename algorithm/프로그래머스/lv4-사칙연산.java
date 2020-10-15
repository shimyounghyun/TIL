import java.util.*;

class Solution {
    public int solution(String arr[]) {            
        int n = arr.length/2+1;
        int[][] max = new int[n][n];
        int[][] min = new int[n][n];
        for (int i=0; i<max.length; i++){
            for (int j=0; j<max[i].length; j++){
                max[i][j] = -1000000000;
                min[i][j] = 1000000000;
            }
        }
        for (int i=0; i<n; i++){
            int num = Integer.parseInt(arr[i*2]);
            max[i][i] = num;
            min[i][i] = num;
        }
        // n : 숫자의 개수
        for (int c=1; c<n; c++){ // 1 ~ n까지
            for (int i=0; i<n-c; i++) { // 0 ~ 
                int j = c+i; 
                for (int k=i; k<j; k++){
                    if (arr[k*2+1].equals("-")) {
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k+1][j]);
                        min[i][j] = Math.min(min[i][k] - max[k+1][j], min[i][j]);
                    }else if (arr[k*2+1].equals("+")){
                        max[i][j] = Math.max(max[i][j], max[i][k]+max[k+1][j]);
                        min[i][j] = Math.min(min[i][k]+min[k+1][j], min[i][j]);
                    }
                }
            }
        }

        return max[0][n-1];
    }
}

class Solution {
    public int solution(int[][] t) {
        int r = t[0][0];
        for (int i=1; i<t.length; i++){
            for (int j=0; j<t[i].length; j++){
                int sum = 0;
                if (j == 0){
                    sum = t[i-1][0] + t[i][0];
                }else if (j == t[i].length - 1){
                    sum = t[i-1][j-1] + t[i][j];
                }else {
                    int best = t[i-1][j] > t[i-1][j-1] ? t[i-1][j] : t[i-1][j-1];
                    sum = best + t[i][j];
                }
                t[i][j] = sum;
                r = r < sum ? sum : r;
            }
        }
        return r;
    }
}

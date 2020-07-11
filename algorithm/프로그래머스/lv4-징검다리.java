import java.util.*;

class Solution {
      public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return binerySearch(distance, rocks, n);
    }
    
    public int binerySearch(int d, int[] r, int n){
        int left = 0;
        int right = d;
        int mid = (left+right)/2;
        int ans = 0;
        while (left <= right){
            int prev = 0;
            int count = 0;
            mid = (left+right)/2;
            for (int i=0; i<r.length; i++){
                if (r[i]-prev < mid)
                    count++;
                else{
                    prev = r[i];
                }
            }
            if (d - prev < mid)
                count++;
            if (count <= n){
                ans = ans < mid ? mid : ans;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
}

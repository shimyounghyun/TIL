import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        if (n <= cores.length) return n;
        int coreMin = cores[0];
        int coreMax = cores[0];
        for (int i=0; i<cores.length; i++){
            coreMin = Math.min(coreMin, cores[i]);
            coreMax = Math.max(coreMax, cores[i]);
        }
        int start = coreMin*n/cores.length-coreMin;
        int end = coreMax*n/cores.length-coreMax;
        int mid = (start+end)/2;
        int answer = 0;
        while (start <= end){
            int sum = cores.length;
            int current = 0;
            for (int c : cores){
                sum += mid/c;
                if ((mid%c) == 0) current++;
            }
            if (sum < n){
                start = mid + 1;
            }else if(sum-current >= n){
                end = mid - 1;
            }else{
                int count = 0;
                for (int i=0; i<cores.length; i++){
                    if ((mid%cores[i])== 0) count++;
                    if (count == n - (sum - current)) return (i+1);
                }
            }
            mid = (start+end)/2;
        }
        return answer;
    }
}

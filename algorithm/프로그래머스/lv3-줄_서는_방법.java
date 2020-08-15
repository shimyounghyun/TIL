import java.util.*;
import java.util.stream.*;

class Solution {
    
    public long factorial(long n){
        long result = 1;
        for (long i=n; i>=1; i--){
            result *= i;
        }
        return result;
    }
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=1; i<=n; i++){
            list.add(i);
        }
        int i=0;
        while(!list.isEmpty()){
            long a = factorial((long)n-(1+i));
            int b = (int)((k-1)/a);
            // System.out.println(k);
            answer[i] = list.remove(b);
            k = ((k-1) % a)+1;
            i++;
        }
        return answer;
    }
}

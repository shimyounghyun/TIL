import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Long> list = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i : works){
            list.add((long)i);
        }
        for (int i=0; i<n; i++){
            long num = list.poll();
            list.add(num-1);
        }        
        while (!list.isEmpty()){
            long num = list.poll();
            if (num > 0)
                answer += num*num;
        }
        return answer;
    }
}

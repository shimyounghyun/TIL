import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int i : scoville){
            q.offer(i);
        }
        while (!q.isEmpty()){
            int item1 = q.poll();
            if (item1 >= K){
                return answer;
            }
            if (q.isEmpty()){
                return -1;
            }
            int item2 = q.poll();
            q.offer(item1 + (item2 * 2));
            answer++;
        }
        return -1;
    }
}

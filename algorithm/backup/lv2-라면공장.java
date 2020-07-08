import java.util.*;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> q = 
            new PriorityQueue<>((x,y)->Integer.compare(y, x));
        int index = 0;
        while (stock < k){
            while (index < dates.length && dates[index] <= stock){
                q.offer(supplies[index]);
                index++;
            }
            stock += q.poll();
            answer++;
        }
        return answer;
    }
}

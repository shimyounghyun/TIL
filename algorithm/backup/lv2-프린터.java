import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<int[]> list = new LinkedList<>();
        
        for (int i=0; i<priorities.length; i++){
            int[] arr = new int[2];
            arr[0] = priorities[i];
            arr[1] = i;
            list.offer(arr);
        }
        
        while (!list.isEmpty()){
            int[] poll = list.poll();
            boolean hasAny = list.stream().anyMatch(x->(x[0] > poll[0])?true:false);
            if (hasAny){
                list.offer(poll);
            }else{
                answer++;
                if (poll[1] == location){
                    return answer;
                }
            }
        }
        return answer;
    }
}

import java.util.*;

class Solution {
    Map<Long, Long> map;
    
    public long find(long key){
        if (map.get(key) == null){
            map.put(key, key+1);
            return key;
        }
        map.put(key, find(map.get(key)));
        return map.get(key);
    }
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        map = new HashMap<>();
        
        for (int i=0; i<room_number.length; i++){
            long num = room_number[i];
            answer[i] = find(num);
        }
        
        return answer;
    }
}

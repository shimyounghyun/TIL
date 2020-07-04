import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String answer = "";
        
        for (String name : participant){
            if (map.get(name) != null)
                map.put(name, map.get(name)+1);
            else
                map.put(name,1);
        }
        
        for (String name : completion){
            map.put(name, map.get(name)-1);
        }
        for (Map.Entry<String,Integer> e : map.entrySet()){
            if (e.getValue() > 0)
                answer = e.getKey();
        }
        return answer;
    }
}

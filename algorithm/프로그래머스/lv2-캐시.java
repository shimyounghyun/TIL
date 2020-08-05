import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> list = new LinkedList<>();
        int answer = 0;
        for (int i=0; i<cities.length; i++){
            cities[i] = cities[i].toUpperCase();
        }
        
        for (String city : cities){
            if (!list.contains(city)){
                answer += 5;
                if (cacheSize > 0){
                    if (list.size() == cacheSize){
                        list.poll();
                    }
                    list.add(city);
                }
            }else{
                list.remove(city);
                list.add(city);
                answer++;
            }
        }
        return answer;
    }
}

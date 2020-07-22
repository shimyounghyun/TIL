import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String gem : gems){
            set.add(gem);
        }
        int count = set.size();
        Map<String, Integer> apache = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (left < gems.length){
            if (apache.size() < count && right < gems.length){
                apache.put(gems[right], apache.getOrDefault(gems[right], 0)+1);
                right++;
            }else{
                apache.put(gems[left], apache.get(gems[left])-1);
                if (apache.get(gems[left]) == 0)
                    apache.remove(gems[left]);
                left++;
            }
            
            if (apache.size() >= count){
                if (right-left < length){
                    answer[0] = left+1;
                    answer[1] = right;
                    length = right-left;
                }                    
            }
        }
        return answer;
    }
}

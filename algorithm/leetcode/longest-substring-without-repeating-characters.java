import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int left = 0;
        int right = 0;
        
        Set<Character> list = new HashSet<>();
        while (right < s.length()){         
            if (list.contains(s.charAt(right))){                
                list.remove(s.charAt(left));
                left++;
            }else{
                list.add(s.charAt(right));
                right++;                
                answer = answer < list.size() ? list.size() : answer;
            }
        }
        
        return answer;
    }
}

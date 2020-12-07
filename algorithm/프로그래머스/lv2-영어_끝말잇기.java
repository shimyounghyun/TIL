import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        String prev = "1";
        for (int i=0; i<words.length; i++){
            char last = prev.charAt(prev.length()-1);
            char last2 = words[i].charAt(0);
            boolean dup = set.add(words[i]);
            if(i>0 && (!dup || last != last2)){
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
            prev = words[i];
        }
        return answer;
    }
}

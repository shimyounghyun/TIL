import java.util.*;
class Solution {
    public int solution(String[] words) {
        int answer = 0;
        
        Arrays.sort(words);
        for (int i=0; i<words.length; i++){
            String word = words[i];
            int j=1;
            while (j < word.length()){
                String w = word.substring(0,j);
                if ((i > 0 && j <= words[i-1].length()
                   && words[i-1].substring(0,j).equals(w))
                   || (i<words.length-1 && j <= words[i+1].length()
                      && words[i+1].substring(0,j).equals(w))){
                    j++;
                    continue;
                }
                break;
            }
            answer+=j;
        }
        return answer;
    }
}


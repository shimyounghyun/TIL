import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> dict = new ArrayList<String>();
        List<Integer> answer = new ArrayList<Integer>();
        
        for (int i=0; i<26; i++){
            dict.add(Character.toString('A'+i));
        }
        int w=0;
        int c=0;
        while (c < msg.length()){
            c = w+1;
            while (c < msg.length() && dict.contains(msg.substring(w, c+1)))                
                c++;
            answer.add(dict.indexOf(msg.substring(w,c))+1);
            if (c < msg.length())
                dict.add(msg.substring(w, c+1));
            w=c;
        }
        int r[] = new int[answer.size()];
        for (int i=0; i<answer.size(); i++)
            r[i]=answer.get(i);
        return r;
    }
}

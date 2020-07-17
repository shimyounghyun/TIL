import java.util.*;

class Solution {
    Set<String> list = new HashSet<>();
    
    public int dfs(String[] user_id, String[] banned_id, int index){
        int answer = 0;
        if (index == banned_id.length){
            int result = 0;
            for (int i=0; i<banned_id.length; i++){
                if (banned_id[i].length() != user_id[i].length())
                    return 0;
                int j = 0;
                while (j < user_id[i].length()
                      && (banned_id[i].charAt(j) == '*' 
                          || user_id[i].charAt(j) == banned_id[i].charAt(j)))
                    j++;
                if (j == user_id[i].length())
                    result++;
            }
            if (result == banned_id.length){
                List<String> s = new ArrayList<>();
                for (int i=0; i<banned_id.length; i++){
                    s.add(user_id[i]);
                }
                Collections.sort(s);
                if (list.add(String.join("",s)))
                    return 1;
            }
            return 0;
        }
        for (int i=index; i<user_id.length; i++){
            String temp = user_id[index];
            user_id[index] = user_id[i];
            user_id[i] = temp;
            answer += dfs(user_id, banned_id, index+1);
            user_id[i] = user_id[index];
            user_id[index] = temp;
        }
        return answer;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        return dfs(user_id, banned_id, 0);
    }
}

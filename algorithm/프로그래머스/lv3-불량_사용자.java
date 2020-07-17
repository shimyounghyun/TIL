import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, 0, 0);
        return set.size();
    }
    
    public void dfs(String[] user_id, String[] banned_id, int index, int bit){
        if (index == banned_id.length){
            set.add(bit);
            return;
        }
        String reg = banned_id[index].replace("*","[\\w\\d]");
        for (int i=0; i<user_id.length; i++){
            if ((bit>>i & 1) == 1 || !user_id[i].matches(reg)) continue;
            dfs(user_id, banned_id, index+1, (bit | (1<<i)));
        }
    }
}

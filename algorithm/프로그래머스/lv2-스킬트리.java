class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i=0; i<skill_trees.length; i++){
            String t = skill_trees[i];
            int s = 0;
            boolean result = true;
            for (int j=0; j<t.length(); j++){
                Character c = t.charAt(j);
                if (skill.indexOf(c) == -1) continue;
                if (skill.indexOf(c) != s) {
                    result = false;
                    break;
                }
                s++;
            }
            if (result) answer++;
            
        }
        return answer;
    }
}

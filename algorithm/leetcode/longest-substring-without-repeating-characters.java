class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        
        for (int i=0; i<s.length(); i++){
            String c = "";   
            for (int j=i; j<s.length(); j++){
                if (c.contains(s.charAt(j)+"")){
                    break;
                }
                c += s.charAt(j);
            }
            answer = answer < c.length() ? c.length() : answer;
        }
        
        return answer;
    }
}

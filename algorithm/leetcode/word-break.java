class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int s_length = s.length();
        LinkedList<Integer> list_index = new LinkedList<Integer>();
        boolean[] r = new boolean[s_length];
        boolean result = false;
        for(String word : wordDict){
            if (s.charAt(0) == word.charAt(0)){
                int j=1;
                while(j<s_length && j<word.length()
                     && s.charAt(j) == word.charAt(j))
                    j++;
                if (j == word.length() && r[j-1] == false){
                    if (j == s_length)
                        return true;
                    list_index.push(word.length());
                    r[j-1] = true;
                }
            }
        }
        while (!list_index.isEmpty()){
            int i=list_index.pop();
            for(String word : wordDict){
                if (s.charAt(i) == word.charAt(0)){
                    int j=1;
                    while(i+j<s_length && j<word.length()
                         && s.charAt(i+j) == word.charAt(j))
                        j++;                    
                    if (j == word.length() && r[i+j-1] == false){
                        if (i+j == s_length)
                            return true;
                        list_index.push(i+j);
                        r[i+j-1]=true;
                    }
                }
            }          
        }
        return false;
    }
}

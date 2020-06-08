class Solution {
    
    public void backtrack(List<String> output, String s, List<String> wordDict,
                         int index, LinkedList<String> w){
        if (index == s.length()){
            output.add(String.join(" ", w));
            return;
        }
        for (String word : wordDict){
            int i=0;
            while (index+i<s.length() && i<word.length() 
                   && s.charAt(index+i)==word.charAt(i))
                i++;
            if (i == word.length()){
                w.add(word);
                backtrack(output, s, wordDict, index+i, w);
                w.remove(w.size()-1);
            }
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        boolean[] r = new boolean[s.length()+1];
        List<String> output = new ArrayList<String>();
        
        r[0]=true;
        for (int i=1; i<s.length()+1; i++){
            for (int j=0; j<i; j++){
                if (r[j] && wordDict.contains(s.substring(j,i))){
                    r[i]=true;
                    break;
                }
            }
        }
        if (r[s.length()]){
            LinkedList<String> w = new LinkedList<String>();
            backtrack(output, s, wordDict, 0, w);    
        }
        return output;
    }
}

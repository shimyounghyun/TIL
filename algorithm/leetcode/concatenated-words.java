class Solution {
    List<String> list;
    
    public boolean isContain(String word, int count){
        if (word.length() == 0 && count > 1)
            return true;
        for (int i=1; i<=word.length(); i++){
            String sub = word.substring(0,i);
            if (list.contains(sub)){
                isContain(word.substring(i, word.length()), count);
            }
        }
        return false;
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        list = Arrays.asList(words);
        List<String> result = new ArrayList<String>();
        
        for (String word : list){
            if (isContain(word, 0)){
                result.add(word);
            }
        }
        return result;
    }
}

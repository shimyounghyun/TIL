class Solution {
    int answer = 0;
    
    public int countDif(String s1, String s2){
        int dif = 0;
        int size = s1.length();
        for (int i=0; i<size; i++){
            if (s1.charAt(i) != s2.charAt(i))
                dif++;
        }
        return dif;
    }
    
    public void dfs(boolean[] status, String begin, String target, String[] words, int r){
        if (begin.equals(target)){
            if (answer == 0){
                answer = r;
            }else{
                answer = answer > r ? r : answer;
            }
            return;
        }
        
        for (int i=0; i<words.length; i++){
            if (status[i])
                continue;
            if (countDif(words[i], begin) == 1){
                status[i] = true;
                dfs(status, words[i], target, words, r+1);
            }
            status[i] = false;
        }
        
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] status = new boolean[words.length];
        for (int i=0; i<words.length; i++){
            if (countDif(begin, words[i]) == 1){
                status[i] = true;
                dfs(status, words[i], target, words, 1);
            }
            status[i] = false;
        }
        return answer;
    }
}

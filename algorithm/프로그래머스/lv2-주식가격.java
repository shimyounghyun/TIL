class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i=0; i<prices.length; i++){
            int r = 0;
            for (int j=i+1; j<prices.length; j++){
                r++;
                if (prices[i] > prices[j])
                    break;
            }
            answer[i]=r;
        }
        return answer;
    }    
}

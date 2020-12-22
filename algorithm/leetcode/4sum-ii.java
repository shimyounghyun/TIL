class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int length = A.length;
        for (int i=0; i<length; i++){
            for (int j=0; j<length; j++){
                int sum = A[i] + B[j];
                if (map.containsKey(sum)){
                    map.put(sum, map.get(sum)+1);
                }else{
                    map.put(sum, 1);
                }
            }
        }
        
        for (int i=0; i<length; i++){
            for (int j=0; j<length; j++){
                int sum = (C[i] + D[j])*-1;
                if (map.containsKey(sum)){
                    answer += map.get(sum);
                }
            }
        }
        
        return answer;
    }
}

class Solution {
    
    public int solution(int n) {
        int[] arr = new int[1000];
        for (int i=1; i<1000; i++){
            arr[i] = arr[i-1]+i;
        }
        int answer = 1;
        for (int i=2; i<1000; i++){
            if (n - arr[i-1] > 0 && (n-arr[i-1])%i == 0)
                answer++;
        }
        return answer;
    }
}

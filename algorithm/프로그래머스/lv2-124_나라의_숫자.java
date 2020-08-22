class Solution {
    public String solution(int n) {
        int arr[] = {4,1,2};
        String answer = "";
        while (n > 0){
            int na = n%3;
            n = n/3;
            if (na == 0)
                n--;
            answer = arr[na]+answer;
        }
        return answer;        
    }
}

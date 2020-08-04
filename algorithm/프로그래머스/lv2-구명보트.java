import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int l = 0;
        int r = people.length-1;
        while (l <= r){
            int sum = people[l]+people[r];
            if (sum > limit){
                r--;
            }else{
                r--;
                l++;
            }
            answer++;
        }
        return answer;
    }
}

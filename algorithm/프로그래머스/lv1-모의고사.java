import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};
        
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        for (int i=0; i<answers.length; i++){
            if (s1[(i%s1.length)] == answers[i])
                ans1++;
            if (s2[(i%s2.length)] == answers[i])
                ans2++;
            if (s3[(i%s3.length)] == answers[i])
                ans3++;
        }
        int bestScore = Math.max(Math.max(ans1, ans2), ans3);
        System.out.println(bestScore);
        if (ans1 >= bestScore)
            list.add(1);
        if (ans2 >= bestScore)
            list.add(2);
        if (ans3 >= bestScore)
            list.add(3);
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}

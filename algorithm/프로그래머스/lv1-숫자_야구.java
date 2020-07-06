import java.util.*;
import java.util.stream.*;

class Solution {
    int[] arr = {1,2,3,4,5,6,7,8,9};
    List<String> candidate = new ArrayList<>();

    public void makeCandidate(int index){
        if (index == 3){
            candidate.add(arr[0]+""+arr[1]+""+arr[2]);
            return;
        }
        for (int i=index; i<9; i++){
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            makeCandidate(index+1);
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public void procCandidate(String nums, int strike, int ball){
        candidate = candidate.stream().filter(str->{
            int s = 0;
            int b = 0;
            for (int i=0; i<3; i++){
                if (str.charAt(i) == nums.charAt(i))
                    s++;
                if (str.contains(nums.charAt(i)+""))
                    b++;
            }
            b -= s;
            if (strike == s && b == ball)
                return true;
            return false;
        }).collect(Collectors.toList());
    }
    public int solution(int[][] baseball) {
        makeCandidate(0);
        for (int i=0; i<baseball.length; i++){
            int[] info = baseball[i];
            procCandidate(info[0]+"", info[1], info[2]);
        }
        return candidate.size();
    }
}

import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    public int[] solution(int[] numbers) {
        int[] temp = new int[2];
        dfs(numbers, temp, 0, 0);
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
    
    public void dfs(int[] numbers, int[] temp, int index, int target){
        if (index == temp.length){
            if (!list.contains(temp[0]+temp[1]))
                list.add(temp[0]+temp[1]);
            return;
        }
        if (target == numbers.length) return;
        temp[index] = numbers[target];
        dfs(numbers, temp, index+1, target+1);
        dfs(numbers, temp, index, target+1);
        
    }
}

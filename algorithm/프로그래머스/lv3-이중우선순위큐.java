import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (String temp : operations){
            String op = temp.split(" ")[0];
            int num = Integer.parseInt(temp.split(" ")[1]);
            if (op.equals("I")){
                list.add(num);
                Collections.sort(list);
            }else if (op.equals("D")){
                if (list.size() == 0)
                    continue;
                Collections.sort(list);                
                if (num == 1){
                    list.removeLast();
                }else if (num == -1){
                    list.removeFirst();
                }
            }
        }
        if (list.size() >= 2){
            answer = new int[2];
            answer[0] = list.getLast();
            answer[1] = list.getFirst();
        }        
        return answer;
    }
}

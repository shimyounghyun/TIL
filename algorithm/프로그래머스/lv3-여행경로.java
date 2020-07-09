import java.util.*;

class Solution {
    public ArrayList search(String[][] t, String to, boolean[] visit){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int result = -1;
        for (int i=0; i < t.length; i++){
            if (visit[i])
                continue;
            if (t[i][0].equals(to)){
                list.add(i);
            }
        }
        return list;
    }
    
    public boolean dfs(Stack result, boolean[] visit, String[][] t, String to, int current){
        if (result.size() == t.length){
            result.push(t[current][1]);
            return true;
        }
        ArrayList<Integer> list = search(t, to, visit);
        if (list.size() == 0)
            return false;
        for (int i=0; i<list.size(); i++){
            int index = list.get(i);
            visit[index] = true;
            result.push(to);
            if (dfs(result, visit, t, t[index][1], index))
                return true;
            visit[index] = false;
            result.pop();
        }
        return false;
    }
    public String[] solution(String[][] t) {
        String[] answer = {};
        int size = t.length;
        boolean[] visit = new boolean[size];
        Stack<String> stack = new Stack<String>();
        Arrays.sort(t, (o1, o2)->{
            if (o1[0].compareTo(o2[0]) == 0){
                return o1[1].compareTo(o2[1]);
            }else{
                return o1[0].compareTo(o2[0]);
            }
        });
        for (int i=0; i<size; i++){
            if (t[i][0].equals("ICN")){
                stack.push(t[i][0]);
                visit[i] = true;
                if (dfs(stack, visit, t, t[i][1], i))
                    break;
                stack.pop();
                visit[i] = false;   
            }
        }
        
        answer = new String[stack.size()];
        int i = stack.size();
        while (!stack.isEmpty() && (i--) > 0){
            String n = stack.pop();
            answer[i] = n;
        }
        return answer;
    }
}

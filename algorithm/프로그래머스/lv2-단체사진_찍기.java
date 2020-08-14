import java.util.*;

class Solution {
    Character[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    Map<Character, Integer> result = new HashMap<>();
    int answer;
    
    public void perm(int index, String[] data) {
        if (index == arr.length){
            boolean check = true;
            for (String r : data){
                int size = Math.abs(result.get(r.charAt(0))-result.get(r.charAt(2)))-1;
                if (r.charAt(3) == '='){
                    if (size != Integer.parseInt(r.charAt(4)+""))
                        check = false;
                }else if (r.charAt(3) == '>'){
                    if (size <= Integer.parseInt(r.charAt(4)+""))
                        check = false;
                }else if (r.charAt(3) == '<'){
                    if (size >= Integer.parseInt(r.charAt(4)+""))
                        check = false;
                }
            }
            if (check){
                answer++;
            }
            return;
        }
        for (int i=index; i<arr.length; i++){
            Character temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            result.put(arr[index], index);
            result.put(arr[i], i);
            perm(index+1, data);
            arr[index] = arr[i];
            arr[i] = temp;
            result.put(arr[index], index);
            result.put(arr[i], i);
        }
    }
    
    public int solution(int n, String[] data) {
        perm(0, data);
        return answer;
    }
}

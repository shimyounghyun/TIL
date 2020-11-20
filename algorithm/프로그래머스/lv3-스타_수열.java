import java.util.*;

class Solution {
    public int solution(int[] a) {
        List<Integer>[] list = new ArrayList[a.length];
        for (int i=0; i<list.length; i++){
            list[i] = new ArrayList<Integer>();
        }
        int max = 0;
        int num = -1;
        for (int i=0; i<list.length; i++){
            list[a[i]].add(i);
            if (max < list[a[i]].size()){
                max = list[a[i]].size();
                num = a[i];
            }
        }
        // 1 2 1
        Set<Integer> check = new HashSet<>();
        int count = 0;
        for(int i=0; i<list[num].size(); i++){
            int index = list[num].get(i);
            check.add(index);
            if (
                (index > 0 && check.add(index-1) && num != a[index-1])
                || (index < a.length-1 && check.add(index+1) && num != a[index+1])
            ) count += 2;
        }
        return count;
    }
    
    
}

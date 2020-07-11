import java.util.*;
class Solution {
    public void hanoi(List<int[]> r, int n, int s, int e, int v){
        if (n == 1){
            int[] a = new int[2];
            a[0]=s;
            a[1]=e;
            r.add(a);
            return;
        }
        hanoi(r, n-1, s, v, e);
        int[] a = new int[2];
        a[0]=s;
        a[1]=e;
        r.add(a);
        hanoi(r, n-1, v, e, s);
    }
    public int[][] solution(int n) {
        List<int[]> list = new ArrayList<int[]>();
        hanoi(list, n, 1, 3, 2);
        int[][] answer=new int[list.size()][2];
        for (int i=0; i<list.size(); i++){
            int[] t = list.get(i);
            answer[i][0] = t[0];
            answer[i][1] = t[1];
        }
        return answer;
    }
}

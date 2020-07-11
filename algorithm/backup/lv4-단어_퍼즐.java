import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int size = t.length();
        Set<String> dic = new HashSet<String>();
        Set<Integer> dicInt = new HashSet<Integer>();
        for (String s : strs){
            dic.add(s);
            dicInt.add(s.length());
        }
        boolean[] check = new boolean[size+1];
        int[] result = new int[size+1];
        int answer=Integer.MAX_VALUE;
        check[0]=true;
        for (int i=0; i<size; i++){
            if (check[i] == false)
                continue;
            for (int word : dicInt){
                int j = i + word;
                if (j <= size && dic.contains(t.substring(i,j))){
                    check[j]=true;
                    int r = result[j]==0||result[j]>result[i]+1?result[i]+1:result[j];
                    if (j == size){
                        if (answer > r)
                            answer=r;
                    }else{
                        result[j]=r;
                    }
                }
            }
        }
        if (check[size] == false)
            return -1;
        return answer;
    }
}

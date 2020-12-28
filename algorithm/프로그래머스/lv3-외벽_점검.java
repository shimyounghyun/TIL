import java.util.*;

class Solution {
    int answer = -1;
    public void dfs(int[] circle, int index, int[] arr){
        if (index == arr.length){
            int current = -1;
            int count = 0;
            int arr_index = 0;
            for (int i=0; i<circle.length; i++){
                if (current >= circle[i]) continue;
                if (arr_index >= arr.length) break;
                current = circle[i]+arr[arr_index];
                arr_index++;
                count++;
            }
            if (current >= circle[circle.length-1]){
                answer = answer==-1 ? count : Math.min(answer, count);
            }
            return;
        }
        for (int i=index; i<arr.length; i++){
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            dfs(circle, index+1, arr);
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
    
    public int solution(int n, int[] w, int[] d) {
        
        int[] range = new int[w.length*2-1];
        for (int i=0; i<w.length; i++){
            range[i] = w[i];
            if (i < w.length-1) range[i+w.length] = range[i]+n;
        }
        
        for (int i=0; i<w.length; i++){
            dfs(Arrays.copyOfRange(range, i, i+w.length), 0, d);
        }
        return answer;
    }
}

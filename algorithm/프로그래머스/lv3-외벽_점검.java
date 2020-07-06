import java.util.*;

class Solution {
    int answer = -1;
    public void permutation(int[] c, int start, int end,
                           int index, int[] d){
        if (index == d.length){
            // for (int t : d){
            //     System.out.print(t + " ");
            // }
            // System.out.println("");
            int count=0;
            int current = -1;
            int k=0;
            for (int j=start; j<end; j++){
                if (current >= c[j])
                    continue;
                if (k >= d.length){
                    count = -1;
                    break;
                }
                current = c[j]+d[d.length-k-1];
                count++;
                k++;
            }
            if (answer == -1){
                answer = count;
            }else if (count != -1){
                answer = Math.min(answer, count);
            }
            return;
        }
        for (int i=index; i<d.length; i++){
            int temp = d[i];
            d[i]=d[index];
            d[index]=temp;
            permutation(c, start, end, index+1, d);
            d[index]=d[i];
            d[i]=temp;
        }
    }
    
    public int solution(int n, int[] w, int[] d) {
        if (w.length == 1)
            return 1;
        int[] c = new int[w.length*2-1];
        for (int i=0; i<w.length; i++){
            c[i]=w[i];
            if (i < w.length-1)
                c[w.length+i]=w[i]+n;
        }
        for (int t : c){
            System.out.print(t+" ");
        }
        // System.out.println("");
        for (int i=0; i<w.length; i++){
            permutation(c,i,i+w.length,0,d);
        }
        return answer;
    }
}

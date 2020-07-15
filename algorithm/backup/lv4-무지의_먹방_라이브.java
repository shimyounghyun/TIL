import java.util.*;

class Solution {
 
    public int solution(int[] f, long k) {
        int[][] r = new int[f.length][2];
        for (int i=0; i<f.length; ++i){
            r[i][0] = f[i];
            r[i][1] = i;
        }
        Arrays.sort(r, (o1, o2)->{
            if (o1[0] == o2[0]){
                return Integer.compare(o1[1], o2[1]);
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        });
        long prev = 0;
        for (int i=0; i<f.length; i++){
            if (i>0 && r[i][0] == r[i-1][0])
                continue;
            if ((long)r[i][0] - prev <= 0)
                break;
            long t = ((long)r[i][0]-prev) * ((long)f.length - (long)i);
            prev = (long)r[i][0];
            // System.out.println(t);
            if (k < (long)t){
                
                Arrays.sort(r, i, f.length,(o1,o2)->{
                    return Integer.compare(o1[1], o2[1]);
                });
                // for (int c=0; c<n.length; c++)
                //     System.out.println(n[c][0]+" "+n[c][1]);
                System.out.println(k+" "+t);
                int count = f.length-i;
                int index = (int)(k%(long)count);
                return r[index+i][1]+1;
            }
            k -= t;
            // System.out.println(r[i][0]+","+r[i][1]);
        }
        return -1;
    }
}

import java.util.*;

class Solution {
    public class Node implements Comparable<Node>{
        int stage;
        int fail;
        int pass;
        
        public double getFail(){
            if (pass == 0 && fail == 0){
                return 0;
            }else if (pass == 0)
                return 1;
            else
                return (double)this.fail/(double)pass;
        }
        public Node(int stage, int fail, int pass){
            this.stage = stage;
            this.fail = fail;
            this.pass = pass;
        }
        
        @Override
        public int compareTo(Node n){
            return Double.compare(n.getFail(), this.getFail());
        }
    }
    public int[] solution(int N, int[] s) {
        int[] answer = new int[N];
        List<Node> list = new ArrayList<>();
        Arrays.sort(s);
        
        for (int i=1; i<=N; i++){
            list.add(new Node(i,0,0));
        }
        
        for (int i=0; i<s.length; i++){
            Node n;
            if (s[i] <= N){
                n = list.get(s[i]-1);
                n.fail++;
                n.pass=s.length-i+n.fail-1;
            }
        }
        Collections.sort(list);
        for (int i=0; i<answer.length; i++)
            answer[i]=list.get(i).stage;
        return answer;
    }
}


import java.util.*;

class Solution {
    public class Node{
        int num;
        int x;
        int y;
        Node left;
        Node right;
        
        public Node(int num, int x, int y){
            this.num = num;
            this.x=x;
            this.y=y;
        }
        
        public void add(Node n){
            if (this.num == 0){
                this.num = n.num;
                this.x=n.x;
                this.y=n.y;
                return;
            }
            if (this.x < n.x){
                if (this.right == null)
                    this.right = n;
                else
                    this.right.add(n);
            }else{
                if (this.left == null)
                    this.left = n;
                else
                    this.left.add(n);
            }
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (int i=0; i<nodeinfo.length; i++){
            map.put(nodeinfo[i][0]+""+nodeinfo[i][1],i+1);
        }
        Arrays.sort(nodeinfo, (o1, o2)->{
            if (o1[1] == o2[1]){
                return Integer.compare(o1[0], o2[0]);
            }else {
                return Integer.compare(o2[1], o1[1]);
            }
        });
        Node root = new Node(map.get(nodeinfo[0][0]+""+nodeinfo[0][1])
                             , nodeinfo[0][0], nodeinfo[0][1]);
        for (int i=1; i<nodeinfo.length; i++){
            // System.out.println("번호 : "+map.get(nodeinfo[i][0]+""+nodeinfo[i][1]));
            root.add(new Node(map.get(nodeinfo[i][0]+""+nodeinfo[i][1])
                             , nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        int[][] answer = new int[2][nodeinfo.length];
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> after = new ArrayList<Integer>();
        preOrder(pre, root);
        afterOrder(after, root);
        for(int i=0; i<nodeinfo.length; i++){
            answer[0][i] = pre.get(i);
            answer[1][i] = after.get(i);
            // System.out.print(after.get(i)+" ");
        }
        return answer;
    }
    
    public void preOrder(List<Integer> list, Node root){
        if (root == null)
            return;
        list.add(root.num);
        preOrder(list, root.left);
        preOrder(list, root.right);
    }
    
    public void afterOrder(List<Integer> list, Node root){
        if (root == null)
            return;
        afterOrder(list, root.left);
        afterOrder(list, root.right);
        list.add(root.num);
    }
}

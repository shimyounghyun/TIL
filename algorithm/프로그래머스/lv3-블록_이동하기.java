import java.util.*;
class Solution {
    int[][] dir = {{0,1}, {0,-1},{1,0},{-1,0}};
    int[] rotate = {1,-1};
    Set<String> location = new HashSet<String>();
    Queue<Node> list;
    
    public boolean add (int l1, int l2, int r1, int r2){
        // int[][] l = new int[2][2];
        // l[0][0]=l1;
        // l[0][1]=l2;
        // l[1][0]=r1;
        // l[1][1]=r2;
        // Arrays.sort(l, (o1, o2)->{
        //     if (o1[0] == o2[0])
        //         return Integer.compare(o1[1],o2[1]);
        //     else
        //         return Integer.compare(o1[0],o2[0]);
        // });
        // if (this.location.add(l[0][0]*1000+l[0][1]*100+l[1][0]*10+l[1][1])){
        if (this.location.add(l1+","+l2+","+r1+","+r2)){
            list.add(new Node(l1, l2, r1, r2, 0, 0));
            return true;
        }
        return false;
    }
    
    public class Node {
        int ly;
        int lx;
        int ry;
        int rx;
        int time;
        int p; // 0 : 가로, 1: 세로
        public Node (int l1, int l2, int r1, int r2, int time, int p){
            this.ly=l1;
            this.lx=l2;
            this.ry=r1;
            this.rx=r2;
            this.time=time;
            this.p=p;
        }
    }
    
    public int solution(int[][] board) {
        list = new LinkedList<Node>();
        list.add(new Node(1,1,1,2,0,0));
        add(1,1,1,2);
        int[][] nboard = new int[board.length+2][board.length+2];
        int[][] tboard = new int[board.length+2][board.length+2];
        for (int i=0; i<board.length+2; i++){
            for (int j=0; j<board.length+2; j++){
                tboard[i][j]=Integer.MAX_VALUE;
                if (i == 0 || j == 0 || i == board.length+1 || j == board.length+1){
                    nboard[i][j]=1;
                }else{
                    nboard[i][j]=board[i-1][j-1];
                }                
            }
        }
        int answer = 0;
        while (!list.isEmpty()){
            int size = list.size();
            for (int k=0; k<size; k++){
                Node loc = list.poll();
                if ((loc.ly == board.length && loc.lx == board.length) || 
                   (loc.ry == board.length && loc.rx == board.length))
                    return answer;
                for (int i=0; i<4; i++){
                    if (nboard[loc.ly+dir[i][0]][loc.lx+dir[i][1]] == 1
                       || nboard[loc.ry+dir[i][0]][loc.rx+dir[i][1]] == 1)
                        continue;
                    add(loc.ly+dir[i][0], loc.lx+dir[i][1], loc.ry+dir[i][0], loc.rx+dir[i][1]);
                }
                if (loc.ly == loc.ry){
                    for (int r : rotate){
                        if (nboard[loc.ly+r][loc.lx] == 0 && nboard[loc.ry+r][loc.rx] == 0){
                            add(loc.ly, loc.lx, loc.ly+r, loc.lx);
                            add(loc.ry, loc.rx, loc.ry+r, loc.rx);
                        }
                    }
                }else{
                    for (int r : rotate){
                        if (nboard[loc.ly][loc.lx+r] == 0 && nboard[loc.ry][loc.rx+r] == 0){
                            add(loc.ry, loc.rx, loc.ry,loc.rx+r);
                            add(loc.ly, loc.lx, loc.ly, loc.lx+r);
                        }
                    }
                }
            }
            answer++;
        }
       // for (int i : location){
       //     System.out.println(i);
       // }
        // for (int i=0; i<tboard.length; i++){
        //     for (int j=0; j<tboard.length; j++){
        //         System.out.print(tboard[i][j]+" ");
        //     }
        //     System.out.println("");
        // }
        return answer;
    }
    
}

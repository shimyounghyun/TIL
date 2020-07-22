import java.util.*;

class Solution {
    Map<Integer, Pos> map = new HashMap<>();
    
    public class Pos{
        int y;
        int x;
        
        public Pos(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 11;
        init();
        for (int i=0; i<numbers.length; i++){
            int target = numbers[i];
            if (isLeft(target)){
                answer+="L";
                left = target;
            }else if (isRight(target)){
                answer+="R";
                right = target;
            }else{
                int dis1 = getDistance(left, target);
                int dis2 = getDistance(right, target);
                if (dis1 == dis2){
                    if (hand.equals("right")){
                        answer+="R";
                		right = target;
                    }else{
                        answer+="L";
                    	left = target;
                    }
                }else if (dis1 < dis2){
                    answer+="L";
                    left = target;
                }else{
                    answer+="R";
                	right = target;
                }
            }
        }
        return answer;
    }
    
    public boolean isLeft(int t){
        return t == 1 || t == 4 || t == 7;
    }
    
    public boolean isRight(int t){
        return t == 3 || t == 6 || t == 9;
    }
    
    public int getDistance(int a, int b){
        Pos t1 = map.get(a);
        Pos t2 = map.get(b);
        
        return Math.abs(t1.y-t2.y)+Math.abs(t1.x-t2.x);
    }
    
    public void init(){
        map.put(1, new Pos(0,0));
        map.put(2, new Pos(0,1));
        map.put(3, new Pos(0,2));
        map.put(4, new Pos(1,0));
        map.put(5, new Pos(1,1));
        map.put(6, new Pos(1,2));
        map.put(7, new Pos(2,0));
        map.put(8, new Pos(2,1));
        map.put(9, new Pos(2,2));
        map.put(10, new Pos(3,0));
        map.put(0, new Pos(3,1));
        map.put(11, new Pos(3,2));
    }
}

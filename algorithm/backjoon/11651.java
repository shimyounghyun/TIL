import java.util.*;
public class Main{
public static class Pos implements Comparable<Pos>{
        int y;
        int x;
        
        public Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
        
        public int compareTo(Pos p){
            if (this.y == p.y){
                return Integer.compare(this.x, p.x);
            }else{
                return Integer.compare(this.y, p.y);
            }
        }
    }
    
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int input = Integer.parseInt(sc.nextLine());
        
        List<Pos> list = new ArrayList<>();
        for (int i=0; i<input; i++){
            String t = sc.nextLine();
            list.add(new Pos(Integer.parseInt(t.split(" ")[1])
                             , Integer.parseInt(t.split(" ")[0])));
        }
        
        Collections.sort(list);
        for (int i=0; i<list.size(); i++){
            Pos p = list.get(i);
            System.out.println(p.x+" "+p.y);
        }
	}
}

import java.util.*;
public class Main{
public static class User implements Comparable<User>{
        public String name; 
        public int age; 
        
        public User(String name, int age) { 
            this.name = name; 
            this.age = age;
        }
        
        public int compareTo(User u){
            return Integer.compare(this.age, u.age);
        }
    }
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // int t = Integer.parseInt(sc.nextLine());
        int t = Integer.parseInt(sc.nextLine());
        List<User> list = new ArrayList<>();
        for (int i=0; i<t; i++){ 
            String info = sc.nextLine();
            list.add(new User(info.split(" ")[1], Integer.parseInt(info.split(" ")[0])));
        }
        Collections.sort(list);
        for (int i=0;i<list.size(); i++){ 
            System.out.println(list.get(i).age+" "+list.get(i).name);
        } 
    }
}

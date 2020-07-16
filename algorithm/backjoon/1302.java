import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i=0; i<input; i++){
            String title = sc.nextLine();
            map.put(title, map.getOrDefault(title,0)+1);
            max = max < map.get(title) ? map.get(title) : max;
        }
        
        final int maxValue = max;
        System.out.print(
        map.entrySet()
            .stream()
            .filter(e -> e.getValue() == maxValue)
            .map(Map.Entry::getKey)
            .sorted()
            .findFirst().get());
    }
}

import java.util.*;
public class Main{
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, String> hash = new HashMap<>();
        int[][] map = new int[5][5];

        for (int i=0; i<5; i++){
            String[] input = sc.nextLine().split(" ");
            for (int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(input[j]);
                hash.put(input[j],i+","+j);
            }
        }
        
        int answer = 0;
        for (int i=0; i<5; i++){
            String[] input = sc.nextLine().split(" ");
            for (int j=0; j<5; j++){
                if (check(input[j], map, hash) >= 3){
                    if (answer == 0)
                        answer = (i*5)+j+1;
                }
            }
        }
        System.out.println(answer);
	}
    
    public static int check(String target, int[][] map, Map<String, String> hash){
        int y = Integer.parseInt(hash.get(target).split(",")[0]);
        int x = Integer.parseInt(hash.get(target).split(",")[1]);
        map[y][x] = 0;
        int result = 0;
        for (int i=0; i<5; i++){
            int row_count = 0;
            int col_count = 0;
            for (int j=0; j<5; j++){
                if (map[i][j] == 0)
                    row_count++;
                if (map[j][i] == 0)
                    col_count++;
            }
            if (row_count == 5) result++;
            if (col_count == 5) result++;
        }
        if (map[0][0] == 0 
           && map[1][1] == 0
           && map[2][2] == 0
           && map[3][3] == 0
           && map[4][4] == 0)
            result++;
        if (map[0][4] == 0 
           && map[1][3] == 0
           && map[2][2] == 0
           && map[3][1] == 0
           && map[4][0] == 0)
            result++;
        return result;
    }
}

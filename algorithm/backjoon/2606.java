import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        boolean[][] arr = new boolean[size+1][size+1];
        int t = Integer.parseInt(sc.nextLine());
        for (int i=0; i<t; i++){
            String input = sc.nextLine();
            int y = Integer.parseInt(input.split(" ")[0]);
            int x = Integer.parseInt(input.split(" ")[1]);
            arr[y][x] = true;
            arr[x][y] = true;
        }
        
        for (int i=0; i<=size; i++){
            for (int j=0; j<=size; j++){
                for (int k=0; k<=size; k++){
                    if (arr[j][i] && arr[i][k])
                        arr[j][k] = true;
                }
            }
        }
        
        int count = 0;
        for (int i=2; i<=size; i++){
            if (arr[1][i])
                count++;
        }
        System.out.println(count);
	}
}

import java.util.*;
public class Main{
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        int[][] arr = new int[15][14];
        for (int i=0; i<14; i++){
            arr[0][i] = i+1;
        }
        for (int i=1; i<15; i++){
            for (int j=0; j<14; j++){
                if (j > 0)
                    arr[i][j] = arr[i][j-1] + arr[i-1][j];
                else
                    arr[i][j] = arr[i-1][j];
            }
        }
        int t = Integer.parseInt(input);
        for (int i=0; i<t; i++){
            int y = Integer.parseInt(sc.nextLine());
            int x = Integer.parseInt(sc.nextLine());
            System.out.println(arr[y][x-1]);
        }                        
	}
}

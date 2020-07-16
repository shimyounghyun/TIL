import java.util.*;
public class Main{
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int input = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[input][2];
        for (int i=0; i<input; i++){
            String info = sc.nextLine();
            arr[i][0] = Integer.parseInt(info.split(" ")[0]);
            arr[i][1] = Integer.parseInt(info.split(" ")[1]);
        }
        for (int i=0; i<arr.length; i++){
            int rank = 1;
            for (int j=0; j<arr.length; j++){
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                    rank++;
            }
            System.out.print(rank+" ");
        }
	}
}

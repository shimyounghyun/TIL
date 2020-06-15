import java.util.*;
import java.io.*;
public class Main {
public static int[][] move(int[][]m){
        int result[][] = new int[m.length][m.length];
        
        for (int i=0; i<m.length; i++){
            int temp = 0;
            int index = 0;
            for (int j=0; j<m.length; j++){
                if (m[i][j] == 0)
                    continue;                
                if (temp != m[i][j]){
                    result[i][index]=m[i][j];
                    index++;
                    temp=m[i][j];
                }else{
                    result[i][index-1] = m[i][j]+result[i][index-1];
                    temp=0;
                }
            }
        }
        return result;
    }
    
    public static int[][] rotate(int type, int[][]m){
        int result[][] = new int[m.length][m.length];
        int size = m.length-1;
        switch (type){
            case 0:
                result=m;
                break;
            case 1:
                for (int i=0; i<m.length; i++){
                    for (int j=0; j<m.length; j++){
                        result[size-j][i]=m[i][j];
                    }
                }
                break;
            case 2:
                for (int i=0; i<m.length; i++){
                    for (int j=0; j<m.length; j++){
                        result[size-i][size-j]=m[i][j];
                    }
                }
                break;
            case 3:
                for (int i=0; i<m.length; i++){
                    for (int j=0; j<m.length; j++){
                        result[j][size-i]=m[i][j];
                    }
                }
                break; 
        }
        return result;
    }
    static int result = 0;
    public static void backtrack(int[][]m, int count){
        if (count == 5){
            for (int i=0; i<m.length; i++){
                for (int j=0; j<m.length; j++){
                    if (result < m[i][j])
                        result = m[i][j];
                    // System.out.print(m[i][j] +" ");
                }
                // System.out.println("");
            }
            // System.out.println("");
            return;
        }
        for (int i=0; i<4; i++){
            backtrack(move(rotate(i, m)), count+1);
        }
    }

public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int arr[][] = new int[size][size];
    for (int i=0; i<size; i++){        
        for (int j=0; j<size; j++){
            arr[i][j] = sc.nextInt();
        }
    }
    backtrack(arr, 0);
    System.out.println(result);
}
}

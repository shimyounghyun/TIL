import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i=0; i<n; i++){
            String info = br.readLine();
            for (int j=0; j<n; j++){
                if (info.charAt(j) == '1')
                    map[i][j] = 1;
            }
        }
        System.out.println(quardTree(n,0,0));
    }

    public static String quardTree(int size, int y, int x){
        String result = "";
        boolean isSame = true;
        for (int i=y; i<y+size; i++){
            for (int j=x; j<x+size; j++){
                if (map[y][x] != map[i][j]){
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) return map[y][x]+"";
        result += quardTree(size/2, y, x);
        result += quardTree(size/2, y, x+size/2);
        result += quardTree(size/2, y+size/2, x);
        result += quardTree(size/2, y+size/2, x+size/2);
        return "("+result+")";
    }
}

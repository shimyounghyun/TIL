import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int index = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            String info = br.readLine();
            System.out.println(flip(info));
        }
    }

    public static String flip(String info){
        index++;
        if (info.charAt(index) == 'x'){
            String topLeft = flip(info);
            String topRight = flip(info);
            String bottomLeft = flip(info);
            String bottomRight = flip(info);
            return 'x'+bottomLeft+bottomRight+topLeft+topRight;

        }else{
            return info.charAt(index)+"";
        }
    }
}

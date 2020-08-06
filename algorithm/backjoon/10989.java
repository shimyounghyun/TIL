import java.util.*;
import java.io.*;

public class Main{
public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        
        int[] arr = new int[10001];
        int t = Integer.parseInt(input);
        for (int i=0; i<t; i++){
            int index = Integer.parseInt(br.readLine());
            arr[index]++;
        }
        
        for (int i=1; i<=10000; i++){
            for (int j=0; j<arr[i]; j++){
                bw.write(Integer.toString(i)+"\n");
            }
        }
    br.close();
    bw.close();
}
}

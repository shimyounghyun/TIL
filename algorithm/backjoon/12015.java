import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        List<Integer> list = new ArrayList<>();
        String[] input = sc.nextLine().split(" ");
       for (int i=0; i<size; i++){
            int n = Integer.parseInt(input[i]);
            if (list.size() == 0 
                || list.get(list.size()-1) < n) list.add(n);
            else{
                binsearch(list, n);
            }
        }
        System.out.println(list.size());
    }
    
    public static void binsearch(List<Integer> list, int n){
        int start = 0;
        int end = list.size()-1;
        int mid = (start+end)/2;
        int index= mid;
        while (start <= end){
            if (list.get(mid) >= n){
                index = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
            mid = (start+end)/2;
        }
        list.set(index, n);
    }
}

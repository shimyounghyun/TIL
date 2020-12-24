import java.util.*;
import java.util.stream.*;
class Solution {
    final int INS = 1; //설치
    final int DEL = 0; //삭제
    List<int[]> list = new LinkedList<>();
    int[][] map;
    
    public void install(int x, int y, int el){
        if (isPossible(x, y, el+1)){
            map[y][x] = (map[y][x]|(el+1));
            list.add(new int[]{x, y, el});
        }
    }
    
    public void delete(int x, int y, int el){
        map[y][x] = (map[y][x] & ~(el+1));
        for (int[] arr : list){
            if (isPossible(arr[0], arr[1], arr[2]+1) == false){
                map[y][x] = (map[y][x]|(el+1));
                return;
            }
        }
        list = list.stream()
            .filter(v -> !Arrays.equals(v, new int[]{x, y, el}))
            .collect(Collectors.toList());
    }
    
    public boolean isPossible(int x, int y, int el){
       if (el == 1){ // 기둥
           if (y == 0 || (map[y-1][x]&1) == 1 
               || (map[y][x]>>1&1) == 1 || (x > 0 && (map[y][x-1]>>1&1) == 1))
               return true;
       }else{ // 보
           if ((map[y-1][x]&1) == 1 || (map[y-1][x+1]&1) == 1 
              || ((map[y][x+1]>>1&1) ==1 && (x>0 && (map[y][x-1]>>1&1) == 1)))
               return true;
       }
        return false;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        map = new int[n+1][n+1];
        
        for (int[] bf : build_frame){
            int x = bf[0];
            int y = bf[1];
            int el = bf[2];
            int op = bf[3];
            if (op == INS)
                install(x, y, el);
            else
                delete(x, y, el);
        }
        
        Collections.sort(list, (a,b)->{
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });
        
        list.stream()
            .forEach(v -> System.out.println(Arrays.toString(v)));
        
        return list.toArray(new int[list.size()][3]);
    }
}

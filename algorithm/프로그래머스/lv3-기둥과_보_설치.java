import java.util.*;

class Solution {
    final int INS = 1; //설치
    final int DEL = 0; //삭제
    final int PI = 2; //기둥
    final int BO = 1; //보
    
    public boolean hasBO(int num){
        return (num&BO) != 0 ? true : false;
    }
    
    public boolean hasPI(int num){
        return (num&PI) != 0 ? true : false;
    }
    
    public boolean canIns(int[][] m, int x, int y, int a){
        if (a == PI){ //기둥 설치
            if (y == 0)
                return true;
            if (hasPI(m[y-1][x]))
                return true;
            if (x == 0 && hasBO(m[y][x]))
                return true;
            if (x > 0 && (hasBO(m[y][x]) || hasBO(m[y][x-1])))
                return true;
        }else{ //보 설치
            if (hasPI(m[y-1][x]) || hasPI(m[y-1][x+1]) 
                || (x > 0 && hasBO(m[y][x-1]) && hasBO(m[y][x+1])))
                return true;
        }
        return false;
    }
    
    public boolean canDel(int[][] m, int x, int y, int a){
        int[] dirI = {1,1,1,0,0,-1,-1,-1,0};
        int[] dirJ = {-1,0,1,-1,1,-1,0,1,0};
        boolean result=true;
        m[y][x] = m[y][x] & ~a;
        for (int i=0; i<9; i++){
            if (y+dirI[i]<0 || y+dirI[i] >= m.length
               || x+dirJ[i]<0 || y+dirJ[i] >= m.length
               || m[y+dirI[i]][x+dirJ[i]] == 0)
                continue;
            if(canIns(m,x+dirJ[i],y+dirI[i],m[y+dirI[i]][x+dirJ[i]]) == false){
                result = false;
                break;
            }
        }
        m[y][x] |= a;
        return result;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][] map = new int[n+1][n+1];
        int count = 0;
        for (int[] data : build_frame){
            int x = data[0];
            int y = data[1];
            int a = data[2] == 1 ? 1 : 2; //보 01, 기둥 10
            int b = data[3]; //설치 1,삭제0
            switch (b){
                case INS :
                    if (canIns(map, x, y, a)){
                        map[y][x] |= a;
                        count++;
                    }
                    break;
                case DEL :
                    if (canDel(map, x, y, a)){
                        map[y][x] = map[y][x]&~a;
                        count--;
                    }
                    break;
            }
        }
        int[][] result = new int[count][3];
        int index = 0;
        for (int i=0; i<=n; i++){
            for (int j=0; j<=n; j++){
                if (hasBO(map[i][j])){
                    result[index][0]=j;
                    result[index][1]=i;
                    result[index][2]=1;
                    index++;
                }
                if (hasPI(map[i][j])){
                    result[index][0]=j;
                    result[index][1]=i;
                    result[index][2]=0;
                    index++;
                }
            }
        }
        Arrays.sort(result, (o1, o2)->{
            if (o1[0] == o2[0]){
                if(o1[1] == o2[1]){
                    return Integer.compare(o1[2],o2[2]);
                }else{
                    return Integer.compare(o1[1],o2[1]);    
                }
            }else {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        return result;
    }
}

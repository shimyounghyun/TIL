class Solution {

    public int[][] rotate(int[][] map, int m) {
        int size = map.length;
        int[][] n = new int[size][size];

        switch (m){
            case 90 :
                for (int i=0; i<size; i++){
                    for(int j=0; j<size; j++){
                        n[j][(size-1)-i] = map[i][j];
                    }
                }
                break;
            case 180 :
                for (int i=0; i<size; i++){
                    for(int j=0; j<size; j++){
                        n[(size-1)-i][(size-1)-j] = map[i][j];
                    }
                }
                break;
            case 270 :
                for (int i=0; i<size; i++){
                    for(int j=0; j<size; j++){
                        n[(size-1)-j][i] = map[i][j];
                    }
                }
                break;
            default :
                for (int i=0; i<size; i++){
                    for(int j=0; j<size; j++){
                        n[i][j] = map[i][j];
                    }
                }
                break;
        }
        return n;
    }

    public boolean compare(int[][] m, int r, int c, int[][] l){
        int size = l.length;
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                if (m[r+i][c+j] == l[i][j])
                    return false;
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int lockSize = lock.length;
        int keySize = key.length;
        int mapSize = keySize+(lockSize-1)*2;
        int[][] map = new int[mapSize][mapSize]; 

        for (int i=0; i<mapSize; i++){
            for (int j=0; j<mapSize; j++){
                if (lockSize-1 <= i && i < lockSize+keySize-1
                   && lockSize-1 <= j && j < lockSize+keySize-1){
                    map[i][j] = key[i-(lockSize-1)][j-(lockSize-1)];
                }else{
                    map[i][j] = 0;
                }                    
            }
        }
        for (int rot = 0; rot < 360; rot+=90){
            int[][] m = rotate(map, rot);
            for (int i=0; i<mapSize-(lockSize-1); i++){
                for (int j=0; j<mapSize-(lockSize-1); j++){                    
                    if (m[i][j] != lock[0][0] && compare(m, i, j, lock))
                        return true;
                }
            }
        }
        return false;
    }
}

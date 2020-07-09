import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        ArrayList<Integer> candidateKey = new ArrayList<>();
        
        int row = relation.length;
        int col = relation[0].length;
        
        for (int set=1; set<(1<<col); set++){
            if (!isMin(set, candidateKey)) continue;
            
            if (isUnique(set, row, col, candidateKey, relation)){
                // System.out.println(Integer.toBinaryString(set));
                candidateKey.add(set);
            }
        }
        return candidateKey.size();
    }
    
    public boolean isUnique(int set, int row, int col, List<Integer> candidateKey, String[][] relation) {
        Set<String> list = new HashSet<String>();
        
        for (int i=0; i<row; i++){
            String dataByKeySet = "";
            for (int j=0; j<col; j++){
                if ((set & (1 << j)) != 0)
                    dataByKeySet += relation[i][j];
            }
            if (!list.add(dataByKeySet)) return false;
        }
        return true;
    }
    
    public boolean isMin(int set, List<Integer> candidateKey) {
        for (int key : candidateKey){
            if ((key & set) == key) return false;
        }
        return true;
    }
}

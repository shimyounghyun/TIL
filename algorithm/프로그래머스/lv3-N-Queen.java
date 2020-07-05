class Solution {
    int result = 0;
    public boolean check(int[] visit, int index, int position){
        for(int i=0; i<index; i++){
           if (visit[i] == position) return false;
           if (visit[i]+(index-i) == position 
               || visit[i]-(index-i) == position) return false;
        }
        return true;
    }

    public void dfs(int[] visit, int index, int size){
        if (index == size){
            result++;
            for (int i=0; i<size; i++){
                System.out.print(visit[i]);
            }
                            System.out.println("");
            return;
        }
        for (int i=0; i<size; i++){
            if (check(visit, index, i)){
                visit[index] = i;
                dfs(visit, index+1, size);
            }
        }
    }
    
    public int solution(int n) {
        int[] visit = new int[n];
        for (int i=0; i<n; i++){
            visit[i] = -1;
        }
        dfs(visit, 0, n);
        return result;
    }
}

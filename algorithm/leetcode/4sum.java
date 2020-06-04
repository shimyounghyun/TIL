
class Solution {
    public List<List<Integer>> fourSum(int[] n, int t) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(n);
        for (int i=0; i<n.length-3; i++){
            if (i == 0 || n[i-1] < n[i]){
                for (int j = i+1; j<n.length-2; j++){
                    if (j == i+1 || n[j-1] < n[j]){
                        int k = j+1;
                        int l = n.length-1;                        
                        while (k < l){
                            int sum = n[i]+n[j]+n[k]+n[l];
                            if (sum == t){
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(n[i]);
                                list.add(n[j]);
                                list.add(n[k]);
                                list.add(n[l]);
                                result.add(list);
                                while (k < l && n[k] == n[k+1])
                                    k++;
                                while (k < l && n[l] == n[l-1])
                                    l--;
                                k++;
                                l--;
                            }else if (sum < t){
                                k++;
                            }else{
                                l--;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}

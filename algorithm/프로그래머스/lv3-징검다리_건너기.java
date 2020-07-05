class Solution {
    public int check(int[] stones, int mid){
        int n = 0;
        int r = 0;
        for (int m : stones){
            if (m <= mid){
                r++;
                if (n<r)
                    n=r;
            }else{
                r=0;
            }
        }
        return n;
    }
    public int solution(int[] stones, int k) {
        int answer = 0;        
        int start = 1;
        int end = 200000000;
        int mid = (start+end)/2;
        while (start <= end){
            int c = check(stones, mid);
            if (c >= k){
                end = mid-1;
            }else if (c < k){
                start = mid+1;
            }
            mid = (start+end)/2;
        }
        return mid+1;
    }
}

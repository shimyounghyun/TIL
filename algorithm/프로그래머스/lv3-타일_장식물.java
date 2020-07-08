class Solution {
    public long solution(int N) {
        long r1 = 1;
        long r2 = 1;
        long r3 = 0;
        
        long l = 6;
        if (N == 1)
            return 4;
        if (N == 2)
            return 6;
        for (int i=2; i<N; i++){
            long temp = r3;
            r3 = r1 + r2;
            r1 = r2;
            r2 = r3;
            l = l + r3*2;
        }
        return l;
    }
}

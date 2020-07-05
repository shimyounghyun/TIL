class Solution {
    public String itos(int num, int n){
        String c = "0123456789ABCDEF";
        String r = "";

        while (num>=n){
            r = c.substring(num%n, (num%n)+1)+r;
            num /= n;
        }
        return c.charAt(num)+r;
    }

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num=0;
        int turn=0;
        while (answer.length() < t){
            String r = itos(num, n);
            for (int i=0; i<r.length(); i++){
                turn++;
                if ((turn-1) % m == p-1 && answer.length() < t){
                    answer = answer + r.charAt(i);
                }
            }
            num++;
        }
        return answer;
    }
}

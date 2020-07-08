class Solution {    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int i = 1;
        while (i <= yellow){
            int s = i;
            int d = yellow/i;
            if (yellow%i == 0 && d>=s){
                System.out.println(d+" "+s);
                if ( (d+2)*2+s*2 == brown ){
                    answer[0] = d+2;
                    answer[1] = s+2;
                    break;
                }
            }
            i++;
        }
        return answer;
    }
}

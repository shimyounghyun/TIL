import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] ntos = new String[numbers.length];
        
        for (int i=0; i<numbers.length; i++){
            ntos[i] = numbers[i]+"";
        }
        String r = Arrays
                .stream(ntos)
                .sorted(new Comparator<String>(){
                    @Override
                    public int compare(String a, String b){                    
                        return (b+a).compareTo(a+b);
                    }
                })
                .reduce("",(x,y)->x+y);
        return r.charAt(0) == '0' ? "0" : r;
    }
}

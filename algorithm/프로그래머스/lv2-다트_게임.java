import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        String score = "";
        List<Integer> list = new ArrayList();
        for (int i=0; i<dartResult.length(); i++){
            Character c = dartResult.charAt(i);
            if (Character.isDigit(c)){
                score += c;
            }else if (c == 'S' || c == 'D' || c == 'T'){
                int s = Integer.parseInt(score);                
                switch (c){
                    case 'D': 
                        s = s*s;
                        break;
                    case 'T': 
                        s = s*s*s;
                        break;
                }
                list.add(s);
                score = "";
            }else if(c == '*' || c == '#'){
                switch (c){
                    case '*' :
                        list.set(list.size()-1, list.get(list.size()-1)*2);
                        if (list.size() > 1){
                            list.set(list.size()-2, list.get(list.size()-2)*2);
                        }
                        break;
                    case '#' :
                        list.set(list.size()-1, list.get(list.size()-1)*-1);
                        break;
                }
            } 
        }
        for (int s : list){
            System.out.println(s);
            answer += s;
        }
        return answer;
    }
}

import java.util.*;

class Solution {
    class File implements Comparable<File> {
        String origin;
        String head;
        int number;
        
        public File(String origin){
            this.origin = origin;
            int i=0;
            while (i<origin.length() 
                   && !Character.isDigit(origin.charAt(i)))
                i++;
            this.head = origin.substring(0, i);
            int j=i;
            while (i<origin.length() 
                  && Character.isDigit(origin.charAt(i)))
                i++;
            this.number = Integer.parseInt(origin.substring(j,i));
            
        }
        
        @Override
        public int compareTo(File f){
            String s1 = this.head.toUpperCase();
            String s2 = f.head.toUpperCase();
            
            if (s1.compareTo(s2) == 0){
                return this.number - f.number;
            }else{
                return s1.compareTo(s2);
            }
        }
    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> list = new ArrayList<File>();
        for (String filename : files){
            list.add(new File(filename));
        }
        Collections.sort(list);
        for (int i=0; i<list.size(); i++){
            answer[i] = list.get(i).origin;
            System.out.print(list.get(i).origin+", ");
        }
        return answer;
    }
}

import java.util.*;
class Solution {
    class Tuple implements Comparable<Tuple> {
        int num;
        int count;
        
        public Tuple(int num, int count){
            this.num=num;
            this.count=count;
        }
        
        @Override
        public int compareTo(Tuple t){
            return t.count-this.count;
        }
    }
    public int[] solution(String s) {
        s = s.replaceAll("\\{","").replaceAll("\\}","");
        String[] arr = s.split(",");
        Map<String, Integer> map = new HashMap<String,Integer>();
        List<Tuple> list = new ArrayList<Tuple>();
        for (String w : arr){
            int t = 0;
            if (map.get(w) != null)
                t = map.get(w);
            map.put(w, ++t);
        }
        for (Map.Entry<String, Integer> t : map.entrySet()){
            int key = Integer.parseInt(t.getKey());
            int value = t.getValue();
            list.add(new Tuple(key, value));
        }
        int[] result = new int[list.size()];
        Collections.sort(list);        
        for (int i=0; i<list.size(); i++){
            result[i]=list.get(i).num;
        }
        return result;
    }
}

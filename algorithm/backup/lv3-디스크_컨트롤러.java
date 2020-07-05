import java.util.*;

class Solution {
    class Node {
        int request;
        int work;
        
        public Node(int request, int work){
            super();
            this.request = request;
            this.work = work;
        }
    }
    class Compare extends Node implements Comparable<Compare> {
        
        public Compare (int request, int work){
            super(request, work);
        }
        
        @Override
        public int compareTo(Compare target){
            return this.work - target.work;
        }
    }
    
    class Sort extends Node implements Comparable<Sort>{
        
        public Sort (int request, int work){
            super(request, work);
        }
        
        @Override
        public int compareTo(Sort target){
            if (this.request > target.request){
                return 1;
            }else if (this.request < target.request){
                return -1;
            }else {
                if (this.work > target.work){
                    return 1;
                }else{
                    return -1;
                }
            }
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        int size = jobs.length;
        PriorityQueue<Compare> wait = new PriorityQueue<Compare>();
        List<Sort> sort = new ArrayList<Sort>();
        for (int i=0; i<size; i++){
            sort.add(new Sort(jobs[i][0], jobs[i][1])); 
        }
        Collections.sort(sort);
        int time = 0;
        int index = 0;
        while (index < sort.size() || !wait.isEmpty()){
            Node n = null;
            if (wait.isEmpty()){
                n = sort.get(index++);
            }else{
                n = wait.poll();
            }
            System.out.println(n.request+","+n.work);
            if (time < n.request)
                time = n.request;
            time += n.work;
            while (index < sort.size() && sort.get(index).request <= time){
                wait.offer(new Compare(sort.get(index).request, sort.get(index).work));
                index++;
            }
            answer += time - n.request;
            // System.out.println(time+","+n.work+","+n.request+" 답 :"+answer);
        }
        return answer/size;
    }
}

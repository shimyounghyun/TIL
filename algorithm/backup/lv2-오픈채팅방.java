import java.util.*;

class Solution {
    public class Message {
        String uid;
        String status; 
        
        public Message(String uid, String s){
            this.uid = uid;
            this.status="Leave".equals(s) ? "나갔습니다." : "들어왔습니다.";
        }
    }
    public String[] solution(String[] record) {
        Queue<Message> list = new LinkedList<Message>();
        Map<String, String> user = new HashMap<String, String>();
        
        for (String msg : record){
            String[] info = msg.split(" ");
            if (!info[0].equals("Leave"))
                user.put(info[1], info[2]);
            if (!info[0].equals("Change")){
                list.offer(new Message(info[1], info[0]));
            }
        }
        String[] result = new String[list.size()];
        int index = 0;
        while (!list.isEmpty()){
            Message m = list.poll();
            result[index] = user.get(m.uid)+"님이 "+m.status;
            index++;
        }
        return result;
    }
}

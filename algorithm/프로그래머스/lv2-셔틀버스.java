import java.util.*;

class Solution {
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        // List<Bus> buslist = new ArrayList<>();
        Arrays.sort(timetable);
        
        int startHour = 9;
        int startMin = 0;
        int index = 0;
        int count = 0;
        for (int i=0; i<n; i++){
            count=0;
            for (int j=index; j<timetable.length; j++){
                String time = timetable[j];
                int crewHour = Integer.parseInt(time.split(":")[0]);
                int crewMin = Integer.parseInt(time.split(":")[1]);
                if (startHour*60+startMin >= crewHour*60+crewMin){
                    count++;
                    index++;
                }
                if (count == m)
                    break;
            }
            if (i < n-1){
                startMin += t;
                if (startMin >= 60){
                    startHour++;
                    startMin = startMin % 60;
                }
            }
        }
        
        if (count == m){ //인원이 다 찬경우
            int lastHour = Integer.parseInt(timetable[index-1].split(":")[0]);
            int lastMin = Integer.parseInt(timetable[index-1].split(":")[1]);
            
            int resultHour = lastHour;
            int resultMin = lastMin-1;
            
            if (resultMin < 0){
                resultMin = 59;
                resultHour--;
            }
            answer = getTime(resultHour, resultMin);
        }else{
            answer = getTime(startHour, startMin);
        }
        return answer;
    }
    
    public String getTime(int hour, int min){
        String result = "";
        
        if (hour < 10){
            result += "0";
        }
        result += hour +":";
        if (min < 10){
            result += "0";
        }
        result += min;
        return result;
    }
}

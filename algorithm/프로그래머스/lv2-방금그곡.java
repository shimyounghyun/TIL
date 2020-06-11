class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int longplayTime = 0;
        m = m.replaceAll("C#","c").replaceAll("D#","d").replaceAll("F#","f").replaceAll("G#","g").replaceAll("A#","a");
        for (String info : musicinfos){
            String[] o=info.split(",");
            String startText=o[0];
            String endText=o[1];
            String title=o[2];
            String melody=o[3];
            int startHour=Integer.parseInt(startText.split(":")[0]);
            int startMin=Integer.parseInt(startText.split(":")[1]);
            int endHour=Integer.parseInt(endText.split(":")[0]);
            int endMin=Integer.parseInt(endText.split(":")[1]);
            int playTime=(endHour*60+endMin)-(startHour*60+startMin);
            String newM = "";
            int i=0;
            melody = melody.replaceAll("C#","c").replaceAll("D#","d").replaceAll("F#","f").replaceAll("G#","g").replaceAll("A#","a");
            int length = melody.length() > playTime? playTime : melody.length();
            while (i<playTime){
                int index = i%length;
                newM = newM + melody.charAt(index);
                i++;
            }
            if (newM.contains(m)){
                if (longplayTime < playTime){
                    answer=title;
                    longplayTime=playTime;
                }
            }
        }
        if (answer.equals(""))
            answer="(None)";
        return answer;
    }
}

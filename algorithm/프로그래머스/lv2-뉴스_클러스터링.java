import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        getList(list1, str1);
        getList(list2, str2);
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        System.out.println(list1);
        System.out.println(list2);
        if (list1.size() == 0 && list2.size() == 0)
            return 65536;
        
        List<String> iList = getIntersection(list1, list2);
        int iSize = iList.size();
        List<String> uList = getUnion(list1, list2, iList);
        int uSize = uList.size();
        System.out.println(iList);
        System.out.println(uList);
        double r = (double)iSize/(double)uSize;
        return (int)(r*(double)65536);
    }
    
    public List<String> getIntersection(List<String> l1, List<String> l2){
        List<String> result = new ArrayList<>();
        int index = 0;
        int l1_len = 0;
        int l2_len = 0;
        
        while(l1_len < l1.size() && l2_len < l2.size()){
            if (l1.get(l1_len).equals(l2.get(l2_len))){
                result.add(l1.get(l1_len));
                l1_len++;
                l2_len++;
            }else if (l1.get(l1_len).compareTo(l2.get(l2_len)) <  0){
                l1_len++;
            }else{
                l2_len++;
            }
        }
        return result;
    }
    
    public List<String> getUnion(List<String> l1, List<String> l2, List<String> interList){
        List<String> result = new ArrayList<>();
        for (String temp : l1){
            result.add(temp);
        }
        for (String temp : l2){
            result.add(temp);
        }
        for (String r : interList){
            result.remove(r);
        }
        return result;
    }
    
    public void getList(List<String> list, String str){
        for (int i=0; i<str.length()-1; i++){
            Character pre = str.charAt(i);
            Character ext = str.charAt(i+1);
            if (!(Character.isAlphabetic(pre) && Character.isAlphabetic(ext)))
                continue;
            String group = str.substring(i,i+2);
            if (group.length() == 2){
                list.add(group);
                group = "";
            }
        }
    }
}

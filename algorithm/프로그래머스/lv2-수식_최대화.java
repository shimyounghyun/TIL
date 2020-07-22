import java.util.*;
import java.util.stream.*;

class Solution {
    LinkedList<String> list = new LinkedList<>();
    long answer = 0;
    public long solution(String expression) {
        String num = "";
        for (int i=0; i<expression.length(); i++){
            Character c = expression.charAt(i);
            if (Character.isDigit(c)){
                num += c;
            }else if (c == '-' || c == '*' || c == '+'){
                list.add(num);
                list.add(c+"");
                num="";
            }
            if (i == expression.length()-1)
                list.add(num);
        }
        // for (String c : list){
        //     System.out.println(c);
        // }
        // System.out.println();
        // cal("-");
        // for (String c : list){
        //     System.out.println(c);
        // }
        String[] arr = {"+","-","*"};
        permu(arr, 0);
        return answer;
    }
    public void permu(String[] arr, int index){
        if (index == arr.length){
            LinkedList<String> newList = list;
            for (String ex : arr){
                newList = cal(ex, newList);
            }
            long result = Math.abs(Long.parseLong(newList.get(0)));
            answer = result > answer ? result : answer;
        }
        for (int i=index; i<arr.length; i++){
            String temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            permu(arr, index+1);
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
    
    public long cal(String num1, String sign, String num2){
        long a = Long.parseLong(num1);
        long b = Long.parseLong(num2);
        long result = 0;
        switch (sign){
            case "*":
                result = a*b;
                break;
            case "-":
                result = a-b;
                break;
            case "+":
                result = a+b;
                break;
        }
        return result;
    }
    
    public LinkedList<String> cal(String sign, LinkedList<String> list){    
        LinkedList<String> newList = new LinkedList<>();
        for (int i=0; i<list.size(); i++){
            String expression = list.get(i);
            if (expression.equals(sign)){
                String prev = newList.get(newList.size()-1);
                String next = list.get(i+1);
                long result = cal(prev, sign, next);
                newList.set(newList.size()-1, result+"");
                i++;
            }else{
                newList.add(expression);
            }
        }
        return newList;
    }
}

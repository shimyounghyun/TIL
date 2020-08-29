import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<String> list = new HashSet<>();
        LinkedList<String> stack = new LinkedList<>();
        LinkedList<String> info = new LinkedList<>();
        String testCase = sc.nextLine();

        for (int i=0; i<testCase.length(); i++){
            Character c = testCase.charAt(i);
            
            if (c == '('){
                stack.push(i+",");
            }else if (c == ')'){
                info.add(stack.poll()+i);
            }
        }

        int size = info.size();
        for (int i=1; i<(1<<size); i++){
            StringBuilder temp = new StringBuilder(testCase);
            for (int j=0; j<size; j++){
                if (((i>>j)&1) == 1){
                    int start = Integer.parseInt(info.get(j).split(",")[0]);
                    int end = Integer.parseInt(info.get(j).split(",")[1]);
                    temp.setCharAt(start, 'x');
                    temp.setCharAt(end, 'x');
                }
            }
            list.add(temp.toString().replaceAll("x",""));
        }
        List<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        for (String s : sortedList){
            System.out.println(s);
        }
    }
}

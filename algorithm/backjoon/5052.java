public class Main{
	public static void main(String[] args){  
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++){
            int count = sc.nextInt();
            String[] arr = new String[count];
            sc.nextLine();
            for (int j=0; j<count; j++){
                arr[j] = sc.nextLine();
            }
            Arrays.sort(arr);
            boolean isContain = false;
            for (int j=0; j<count; j++){
                if (j < count-1 
                   && arr[j+1].startsWith(arr[j])){
                    System.out.println("NO");
                    isContain=true;
                    break;
                }
                if (j < 0
                   && arr[j-1].startsWith(arr[j])){
                    System.out.println("NO");
                    isContain=true;
                    break;
                }
            }
            if (isContain==false)
                System.out.println("YES");
        }
    }
}

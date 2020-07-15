public class Main{
	public static void main(String[] args){
		boolean[] self = new boolean[num+1];
		
		for (int i=1; i<num+1; i++){
			if (self[i] == false){
				System.out.println(i);
			}
			int check = i;
			int sum = i;
			while (check > 0){
				sum += check%10;
				check /= 10;
			}
			if (sum <= num){
				self[sum] = true;
			}
		}
	}
}

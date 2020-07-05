import java.util.*;

class Solution {
    Set<Integer> usedList = new HashSet<>();
    
    public boolean isPrime(int n){
        if (n < 2)
            return false;
        if (n == 2)
            return true;
        if (n%2 == 0)
            return false;
        int i = 3;
        while (i <= Math.sqrt(n)){
            if (n%i == 0)
                return false;
            i+=2;
        }
        return true;
    }
    
    public int permutation(int size, int index, int[] nums){
        int result = 0;
        if (index == size){
            int sum = 0;
            for (int i=0; i<size; i++){
                sum = sum * 10 + nums[i];
            }
            if (usedList.add(sum) && isPrime(sum))
                return 1;
            else
                return 0;
        }
        for (int i=index; i<nums.length; i++){
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            result += permutation(size, index+1, nums);
            nums[index] = nums[i];
            nums[i] = temp;
        }
        return result;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        int length = numbers.length();
        int[] nums = new int[length];
        
        for (int i=0; i<length; i++){
            nums[i] = Integer.parseInt(numbers.charAt(i)+"");
        }
        for (int i=1; i<=length; i++){
            answer += permutation(i, 0, nums);
        }
        return answer;
    }
}

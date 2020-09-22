import java.util.*;
class Solution {
    int count = 0;
    public int solution(int[] nums) {
        
        int[] temp = new int[3];
        dfs(nums, temp, 0, 0);

        return count;
    }
    public boolean isPrime(int n){
        if (n == 1) return false;
        else if(n ==2) return true;
        if (n % 2 == 0) return false;
        int root =  (int)Math.sqrt(n)+1;
        for (int i=3; i<root; i+=2){
            if (n%i == 0) return false;
        }
        return true;
    }
    public void dfs(int[] nums, int[] temp, int index, int target){
        if (index == temp.length){
            int sum = 0;
            for (int i=0; i<temp.length; i++)
                sum += temp[i];
            // System.out.println(Arrays.toString(temp));
            if (isPrime(sum)) count++;
            return;
        }else if (target == nums.length) return;
        temp[index] = nums[target];
        dfs (nums, temp, index+1, target+1);
        dfs (nums, temp, index, target+1);
    }
}

import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int answer = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while (j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum > target){
                    k--;
                }else{
                    j++;
                }
                if (Math.abs(target-sum) < Math.abs(target-answer))
                    answer = sum;
            }
        }
        return answer;
    }
}

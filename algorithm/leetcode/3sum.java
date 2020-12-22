import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while (j < k){
                if (nums[i]+nums[j]+nums[k] == 0){
                    List<Integer> sum = new ArrayList<>();
                    sum.add(nums[i]);
                    sum.add(nums[j]);
                    sum.add(nums[k]);
                    list.add(sum);
                    while (j+1<k && nums[j] == nums[j+1]) j++;
                    while (j<k-1 && nums[k] == nums[k-1]) k--;
                    j++;
                }else if (nums[i]+nums[j]+nums[k] < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return list;
    }
}

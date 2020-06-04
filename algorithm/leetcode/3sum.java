class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++){
            if (i == 0 || nums[i-1] < nums[i]){
                int j = i+1;
                int k = nums.length - 1;
                while (j < k){
                    int sum = nums[i]+nums[j]+nums[k];
                    if (sum == 0){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        while (j < k && nums[k] == nums[k-1])
                            k--;
                        while (j < k && nums[j] == nums[j+1])
                            j++;
                    }else if(sum > 0){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }
        return (result);
    }
}

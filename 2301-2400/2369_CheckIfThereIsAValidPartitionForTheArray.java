class Solution {
    public boolean validPartition(int[] nums) {
        int[] mark = new int[nums.length];
        return dp(nums, 0, mark) == 1;
    }

    public int dp(int[] nums, int idx, int[] mark) {
        if (idx == nums.length) return 1;
        if (idx == nums.length - 1 || idx>nums.length) return -1;
        if (mark[idx] != 0) return mark[idx];

        mark[idx] =  (nums[idx] == nums[idx+1] && dp(nums, idx+2, mark) == 1) ||  
            (idx+2 <= nums.length-1 && 
            ((nums[idx] == nums[idx+1] && nums[idx+1] == nums[idx+2]) || 
            (nums[idx]+1 == nums[idx+1] && nums[idx+1]+1 == nums[idx+2])) && dp(nums, idx+3, mark) == 1) ? 1 : -1;

        return mark[idx];

    }
}
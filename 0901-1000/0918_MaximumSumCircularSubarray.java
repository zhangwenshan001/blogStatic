class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = -30001;
        int min = 30001;

        int curMax = -30001;
        int curMin = 30001; 

        int total = 0;
        for (int i = 0;i<nums.length;i++) {
            total += nums[i];
            curMax = Math.max(curMax+nums[i], nums[i]);
            max = Math.max(max,curMax);
            if (i > 0 && i<nums.length-1) {
                curMin = Math.min(curMin + nums[i], nums[i]);
                min = Math.min(min, curMin);
            }
        }
        return Math.max(max, total-min);        
    }
}
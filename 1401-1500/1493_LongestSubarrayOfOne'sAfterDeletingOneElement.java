class Solution {
    public int longestSubarray(int[] nums) {
        int preCount = 0;
        int curCount = 0;
        int ans = 0;
        for (int i = 0;i<nums.length;i++) {
            if (nums[i] == 1) curCount++;
            else {
                ans = Math.max(ans, preCount + curCount);
                preCount = curCount;
                curCount = 0;
            }
        }
        return Math.min(nums.length - 1, Math.max(ans, preCount+curCount));
    }
}
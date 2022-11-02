class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int curSum = 0;
        int preIdx = 0;
        int ans = 0;
        for (int i = 0;i<nums.length;i++) {
            curSum += nums[i];
            if (curSum < target) {
                continue;
            } 
            while(curSum >= target) {
                curSum -= nums[preIdx++];
            }
            ans = (ans == 0) ? i-preIdx+2 : Math.min(ans, i-preIdx+2);
        }
        return ans;
    }
}
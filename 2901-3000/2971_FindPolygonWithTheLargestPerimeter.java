class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long curSum = nums[0] + nums[1];
        long ans = -1;
        for (int i = 2;i<nums.length;i++) {
            if (curSum > nums[i]) {
                ans = Math.max(ans, curSum + nums[i]);
            }
            curSum += nums[i];
        }
        return ans;
    }
}
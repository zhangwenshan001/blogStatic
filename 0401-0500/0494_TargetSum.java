class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWaysFromIndex(nums, S, 0);
    }
    public int  findTargetSumWaysFromIndex(int[] nums, int S, int start) {
		if (start == nums.length-1) {
            if (S==0 && nums[start] == 0) {
				return 2;
			}
			if (S == nums[start] || S == -nums[start]) {
				return 1;
			}
			else {
				return 0;
			}
		}
		return findTargetSumWaysFromIndex(nums, S-nums[start], start+1)
				+findTargetSumWaysFromIndex(nums, S+nums[start], start+1);
	}
}
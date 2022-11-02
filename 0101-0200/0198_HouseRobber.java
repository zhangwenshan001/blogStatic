class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
			return 0;
		}

		int prev1 = 0;
		int prev2 = 0;

		for (int num : nums) {
			int tmp = prev1;
			prev1 = Math.max(prev1, prev2 + num);
			prev2 = tmp;
		}

		return prev1;
    }
    
    public int maxAmountFromIndex(int[] nums, int index)
	{
		if (index >= nums.length) {
			return 0;
		}

		if (index == nums.length-1) {
			return nums[index];
		}

		int maxFromCur = maxAmountFromIndex(nums, index+2) + nums[index];
		int maxFromNext = maxAmountFromIndex(nums, index+3) + nums[index+1];
		return Math.max(maxFromCur, maxFromNext);

	}
    
}
class Solution {
    public int maxProduct(int[] nums) {
         if (nums.length == 1) {
			 return nums[0];
		 }
		 int n = nums.length;
		 int[] dp = new int[n];
         int[] min = new int[n];
		 dp[0] = nums[0];
         min[0] = nums[0];
         int res = nums[0];
		 for(int i = 1;i<n;i++) {
			if (nums[i] > 0) {
				 dp[i] = (dp[i-1] > 0) ? dp[i-1] * nums[i] : nums[i];
				 min[i] = (min[i-1] <= 0) ? min[i-1] * nums[i] : nums[i];
			 }else if (nums[i] == 0) {
				 dp[i] = 0;
				 min[i] = 0;
			} else {
				dp[i] = (min[i-1] <= 0) ? min[i-1]*nums[i] : nums[i];
				min[i] = dp[i-1] > 0 ? dp[i-1] * nums[i] : nums[i];
			}
			 res = Math.max(res, dp[i]);
		 }
		 return res;
    }
}
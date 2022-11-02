class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length; 
        int[] dp = new int[n+1]; 
        Arrays.fill(dp, Integer.MAX_VALUE); 
        dp[n] = 0; 
        for (int i = n-1; i >= 0; --i) {
            int val = 0; 
            int[] freq = new int[n]; 
            for (int j = i; j < n; ++j) { // sub arr [i, j]
                ++freq[nums[j]]; 
                if (freq[nums[j]] == 2) val += 2; 
                else if (freq[nums[j]] > 2) ++val; 
                dp[i] = Math.min(dp[i], k + val + dp[j+1]); 
            }
        }
        return dp[0]; 
    }
}
class Solution {
    int[][] dp;
    
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return dp(n,k,target);
    }

    public int dp(int n, int k, int target) {
        if (target == 0 && n == 0) return 1;
        if (target <= 0 || n <= 0) return 0;
        if (dp[n][target] >= 0) return dp[n][target];
        
        int ans = 0;
        for (int i = 1;i<=k;i++) {
            ans = (ans + dp(n-1, k, target-i)) % 1000000007;
        }
        return dp[n][target] = ans;
    }
}
class Solution {
    public int integerBreak(int n) {
        if (n <= 3) return n-1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1;i<=n;i++) {
            int p = i;
            for (int j = 0;j<=i/2;j++) {
                p = Math.max(p, dp[j] * dp[i-j]);
            }
            dp[i] = p;
        }
        return dp[n];
    }
}
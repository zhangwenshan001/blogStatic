class Solution {
    public int knightDialer(int n) {
        if (n == 1) return 10;
        long[] dp = new long[10];
        long[] pre = new long[10];
        for (int i = 0;i<10;i++) {
            pre[i] = 1;
        }

        for (int i = 1;i<=n-1;i++) {
            dp[0] = (pre[4] + pre[6]) % 1000000007; 
            dp[1] = (pre[6] + pre[8]) % 1000000007; 
            dp[2] = (pre[7] + pre[9]) % 1000000007; 
            dp[3] = (pre[4] + pre[8]) % 1000000007; 
            dp[4] = (pre[3] + pre[9] + pre[0]) % 1000000007; 
            dp[6] = (pre[1] + pre[7] + pre[0]) % 1000000007; 
            dp[7] = (pre[2] + pre[6]) % 1000000007; 
            dp[8] = (pre[1] + pre[3]) % 1000000007; 
            dp[9] = (pre[2] + pre[4]) % 1000000007; 
            for (int j = 0;j<10;j++) pre[j] = dp[j];
        }
        int ans = 0;
        for(int i = 0;i<10;i++) ans = (ans + (int)dp[i]) % 1000000007; 
        return ans;

    }

}
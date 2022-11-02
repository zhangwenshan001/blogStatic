class Solution {
    int[][] dp;
    public int numWays(int steps, int arrLen) {
        dp = new int[steps+1][Math.min(arrLen, steps) + 1]; // optimize: it can never move to idx: steps+1
        for(int i = 0;i<=steps;i++) {
            Arrays.fill(dp[i], -1);
        }
        return numWaysFrom(steps, arrLen, 0);
    }

    private int numWaysFrom(int steps, int arrLen, int curIdx) {
        if (steps == 0 && curIdx == 0) return 1;
        if (steps == 0 && curIdx > 0) return 0;
        if (dp[steps][curIdx] >= 0) return dp[steps][curIdx];

        int ways = numWaysFrom(steps-1, arrLen, curIdx);
        if (curIdx < arrLen-1) ways = (ways + numWaysFrom(steps-1, arrLen, curIdx+1)) % 1000000007;
        if (curIdx > 0) ways = (ways + numWaysFrom(steps-1, arrLen, curIdx-1)) % 1000000007;
        dp[steps][curIdx] = ways;
        return dp[steps][curIdx];
    }
}
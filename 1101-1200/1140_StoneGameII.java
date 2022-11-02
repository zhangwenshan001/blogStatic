class Solution {
    int sum;
    int[][] dp;
    public int stoneGameII(int[] piles) {
        sum = 0;
        for (int pile : piles) sum += pile;
        dp = new int[piles.length][piles.length];
        return dp(piles, 0, 1, sum);
    }

    private int dp(int[] piles,int i, int m, int postSum) {
        if (i + 2 * m >= piles.length) return postSum;

        if (dp[i][m] > 0) return dp[i][m];
        int ans = 0;
        int nextSum = postSum;
        for (int j = 1;j <= 2 * m; j++) {
            if (i + j >= piles.length) break;
            nextSum -= piles[i+j-1];
            int next = dp(piles, i+j, Math.max(m, j), nextSum);
            ans = Math.max(ans, postSum - next);
        }
        dp[i][m] = ans;
        return ans;
    }
}
class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        dp = new int[s.length()][s.length()];
        return dp(s, 0, s.length()-1);
    }

    private int dp(String s, int i, int j)
    {
        if (j < i) return 0;
        if (j == i) return 1;
        if (dp[i][j] > 0) return dp[i][j];

        int tmp = j;
        while(tmp > i && s.charAt(tmp) != s.charAt(i)) tmp--;
        if (tmp == i) {
            dp[i][j] = dp(s, i+1, j);
        } else {
            dp[i][j] = Math.max(dp(s, i+1, j), dp(s, i+1, tmp-1) + 2);
        }
        return dp[i][j];
    }
}
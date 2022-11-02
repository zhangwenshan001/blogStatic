class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];

        for (int i = questions.length-1;i>=0;i--) {
            if (i == questions.length-1) dp[i] = questions[i][0];
            else if (i + questions[i][1]+1 >= questions.length) {
                dp[i] = Math.max(dp[i+1], questions[i][0]);
            } else {
                dp[i] = Math.max(dp[i+1], questions[i][0] + dp[i + questions[i][1]+1]);
            }
        }
        return dp[0];
    }
}
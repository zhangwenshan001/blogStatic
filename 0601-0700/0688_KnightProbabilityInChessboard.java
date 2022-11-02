class Solution {
    double[][][] dp;
    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) return 1;
        dp = new double[n][n][k+1];
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<n;j++) {
                int count = 0;
                if (i-2 >= 0 && j-1 >=0) count++;
                if (i-1 >= 0 && j-2 >=0) count++;
                if (i-2 >= 0 && j+1 <n) count++;
                if (i-1 >=0 && j+2 < n) count++;
                if (i+2 <n && j-1 >= 0) count++;
                if (i+1 <n && j-2 >=0) count++;
                if (i+2 <n && j+1 <n) count++;
                if (i+1 <n && j+2 <n) count++;
                dp[i][j][1] = (double) count / 8;
            }
        }
        return dp(n,k,row, column);
    }

    private double dp(int n, int k, int row, int column) {
        if (row <0 || row >= n || column < 0 || column >= n) return 0;
        if (k == 1 || dp[row][column][k] > 0) return dp[row][column][k];
        double ans = 0;
        ans += dp(n,k-1, row-2, column-1) / 8;
        ans += dp(n,k-1, row-1, column-2) / 8;
        ans += dp(n,k-1, row-2, column+1) / 8;
        ans += dp(n,k-1, row-1, column+2) / 8;
        ans += dp(n,k-1, row+2, column-1) / 8;
        ans += dp(n,k-1, row+1, column-2) / 8;
        ans += dp(n,k-1, row+2, column+1) / 8;
        ans += dp(n,k-1, row+1, column+2) / 8;

        dp[row][column][k] = ans;
        return ans;
    }
}
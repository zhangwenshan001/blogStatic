class Solution {
    int[] houses;
    int[][] cost;
    int m, n;
    int[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.dp = new int[m][m+1][n+1]; // pos, target, preColor
        return dp(0, target, 0);
    }

    private int dp(int i, int target, int preColor)
    {
        // At pos i, to paint [i, m) target colors and pre color is preColor
        // the min cost is dp[i][target][preColor]
        if (target < 0) return -1;
        if (i >= m) return target == 0 ? 0 : -1;
        if (dp[i][target][preColor] != 0) return dp[i][target][preColor];
        // if has already been painted
        if (houses[i] > 0) {
            return dp(i+1, preColor==houses[i]?target:target-1, houses[i]);
        }
        int curMin = -1;
        for (int j = 1;j<=n;j++) {
            int postCost = dp(i+1, j == preColor ? target: target-1, j);
            if (postCost >= 0) curMin = (curMin == -1) ? cost[i][j-1]+postCost : Math.min(curMin, cost[i][j-1]+postCost);
        }
        dp[i][target][preColor] = curMin;
        return  dp[i][target][preColor];
    }
}

class Solution {
    int max = 0;
    int[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        List<List<Integer>> sums = new ArrayList<>();
        for (int i = 0;i<piles.size();i++) {
            List<Integer> curSum = new ArrayList<>();
            int n = piles.get(i).size();
            for (int j = 0;j< Math.min(n, k);j++) {
                curSum.add(j == 0 ? piles.get(i).get(j) : piles.get(i).get(j) + curSum.get(j-1));
            }
            sums.add(curSum);
        }
        dp = new int[piles.size()][k+1];
        return dp(sums, 0, k);
    }

    private int dp(List<List<Integer>> sums, int i, int k) {
        if (i == sums.size() || k == 0) return 0;

        if (dp[i][k] > 0) return dp[i][k];
        int curMax = dp(sums, i+1, k);
        int n = sums.get(i).size();
        for (int j = 1;j<=k;j++) {
            if (j > n) break;
            curMax =  Math.max(curMax, sums.get(i).get(j-1) + dp(sums, i+1, k-j));
        }
        dp[i][k] = curMax;

        return dp[i][k];
    }

}
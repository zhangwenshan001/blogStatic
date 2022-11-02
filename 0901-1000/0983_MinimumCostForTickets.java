class Solution {
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.sort(days);
        dp = new int[days.length];
        return dp(days, costs, 0);
    }

    private int dp(int[] days, int[] costs, int i) {
        if (i >= days.length) return 0;

        if (dp[i] > 0) return dp[i];
        int one = costs[0] + dp(days, costs, i + 1);

        int k = i;
        while(k < days.length && days[k] - days[i] <= 6) k++;
        int seven = costs[1] + dp(days, costs, k);

        while(k < days.length && days[k] - days[i] <= 29)k++;
        int thirty = costs[2] + dp(days, costs, k);

        dp[i] = Math.min(one, Math.min(seven, thirty));
        return dp[i];
    }
}
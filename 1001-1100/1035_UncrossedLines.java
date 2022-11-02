class Solution {
    int[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][nums2.length];
        for (int i = 0;i<nums1.length;i++) {
            for (int j = 0;j<nums2.length;j++) {
                dp[i][j] = -1;
            }
        }
        return dp(nums1, nums2, 0, 0);
    }

    private int dp(int[] nums1, int[] nums2, int i, int j) {
        if (i == nums1.length || j == nums2.length) return 0;
        if (dp[i][j] >= 0) return dp[i][j];
        if (nums1[i] == nums2[j]) {
            dp[i][j] = dp(nums1, nums2, i+1, j+1) + 1;
        } else {
            dp[i][j] = Math.max(dp(nums1,nums2,i+1,j), dp(nums1,nums2,i,j+1));
        }

        return dp[i][j];
    }
}
class Solution {
    int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()+1][s2.length()+1];
        return minimumDeleteSumFrom(s1,s2,0,0);
    }

    private int minimumDeleteSumFrom(String s1, String s2, int i, int j) {
        if (i == s1.length() && j == s2.length()) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        if (i == s1.length()) return dp[i][j] = s2.charAt(j) - 'a' + 97 + minimumDeleteSumFrom(s1,s2,i, j+1);
        if (j == s2.length()) return dp[i][j] = s1.charAt(i) - 'a' + 97 + minimumDeleteSumFrom(s1,s2,i+1,j);

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = minimumDeleteSumFrom(s1,s2,i+1,j+1);
        }
        return dp[i][j] = Math.min(s1.charAt(i) - 'a' + 97 + minimumDeleteSumFrom(s1,s2,i+1, j), s2.charAt(j) - 'a' + 97 + minimumDeleteSumFrom(s1,s2,i, j+1));
    }
}
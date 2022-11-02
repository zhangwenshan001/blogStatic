class Solution {
    int[][] dp;
    public int countSubstrings(String s, String t) {
        int res = 0;
        dp = new int[s.length()][t.length()];
        for (int i = 0;i<s.length();i++) {
            for (int j = 0;j<t.length();j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0;i<s.length();i++) {
            for (int j = 0;j<t.length();j++) {
                res += countSubstringsFrom(s, i, t, j);
            }
        }

        return res;
    }
    
    private int countSubstringsFrom(String s, int i, String t, int j) {
        if (i >= s.length() || j >= t.length()) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) { 
            dp[i][j] = countSubstringsFrom(s, i+1, t, j+1);
            return dp[i][j];
        }
        int k = 1;
        int ii = i+1;
        int jj = j+1;
        while(ii<s.length() && jj<t.length() && s.charAt(ii) == t.charAt(jj)) {
            k++;
            ii++;
            jj++;
        }
        dp[i][j] = k;
        return dp[i][j];
    }
}
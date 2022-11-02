class Solution {
    int[] dp;
    public int minCut(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return cut(s, 0);
    }

    private int cut(String s, int from) {
        if (dp[from] > 0) return dp[from];
        
        int slen = s.length();
        int ans = Integer.MAX_VALUE;
        for (int i = slen-1;i>=from;i--) {
            boolean isPalindrome = true;
            for (int j = from; j <= (i+1+from)/2;j++) {
                if (s.charAt(j) != s.charAt(i+from-j)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                if (i == slen-1) {
                    dp[from] = 0;
                    return 0;
                }
                else {
                    ans = Math.min(ans, 1 + cut(s,i+1));
                }
            }
        }
        dp[from] = ans;
        return ans;
    }
}
class Solution {
    long mod = (long)1e9 + 7;
    public int numMusicPlaylists(int N, int L, int K) {
        long[][] dp = new long[N + 1][L + 1];
        for (int i = K + 1; i <= N; ++i)
            for (int j = i; j <= L; ++j)
                if ((i == j) || (i == K + 1)) 
                    // if i首歌 == 列表长j  则每首一次,共 1x2x3...xi
                    // if i首歌 == 必须的间隔k+1 则全排列一次， 其它自动确定
                    dp[i][j] = factorial(i);
                else
                    dp[i][j] = (dp[i - 1][j - 1] * i + dp[i][j - 1] * (i - K))  % mod;
        return (int) dp[N][L];
    }

    long factorial(int n) {
        return n > 0 ? factorial(n - 1) * n % mod : 1;
    }
}
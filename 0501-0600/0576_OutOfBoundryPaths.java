class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) return 0;
        int[][] counts = new int[m][n];
        for (int j = 0;j<n;j++) {
            counts[0][j]++;
            counts[m-1][j]++;
        }
        for (int i = 0;i<m;i++) {
            counts[i][0]++;
            counts[i][n-1]++;
        }

        int ans = counts[startRow][startColumn];
        for (int k = 2;k<=maxMove;k++) {
            int[][] tmp = new int[m][n];
            for (int i =0;i<m;i++) {
                for (int j = 0;j<n;j++) {
                    if (i > 0) tmp[i][j] = (counts[i-1][j] + tmp[i][j]) % 1000000007;
                    if (i < m-1) tmp[i][j] = (counts[i+1][j] + tmp[i][j]) % 1000000007;
                    if (j > 0) tmp[i][j] = (counts[i][j-1] + tmp[i][j]) % 1000000007;
                    if (j < n-1) tmp[i][j] = (counts[i][j+1] + tmp[i][j]) % 1000000007;
                }
            }
            counts = tmp;
            ans = (ans + counts[startRow][startColumn]) % 1000000007;
        }
        return ans;
    }
}
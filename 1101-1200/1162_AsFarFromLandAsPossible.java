class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        int res = -1;
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<n;j++) {
                dist[i][j] = 2 * n;
            }
        }

        for (int i = 0;i<n;i++) {
            for (int j = 0;j<n;j++) {
                if (grid[i][j] == 1) dist[i][j] = 0;
                else {
                    if (i > 0) dist[i][j] = Math.min(dist[i][j], dist[i-1][j] + 1);
                    if (j > 0) dist[i][j] = Math.min(dist[i][j], dist[i][j-1] + 1);
                }
            }
        }

        for (int i = n-1;i>=0;i--) {
            for (int j = n-1;j>=0;j--) {
                if (i < n-1) dist[i][j] = Math.min(dist[i][j], dist[i+1][j] + 1);
                if (j < n-1) dist[i][j] = Math.min(dist[i][j], dist[i][j+1] + 1);
                if (dist[i][j] > 0) {
                    res = (res < 0) ? dist[i][j] : Math.max(res,  dist[i][j]);
                }
            }
        }

        return res == 2 * n ? -1 : res;
    }
};
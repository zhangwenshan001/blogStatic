class Solution {
    int ans = 0;
    int m;
    int n;
    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] paths = new int[m][n];
        for (int i = 0;i<m;i++) {
            for (int j = 0;j<n;j++) {
                dfs(grid, paths, i, j);
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int[][] paths, int i, int j) {
        if (paths[i][j] > 0) return;

        int cur = 1;
        if (i > 0 && grid[i][j] < grid[i-1][j]) {
            dfs(grid, paths, i-1, j);
            cur = (cur + paths[i-1][j]) % 1000000007;
        }
        if (j > 0 && grid[i][j] < grid[i][j-1]) {
            dfs(grid, paths, i, j-1);
            cur = (cur + paths[i][j-1]) % 1000000007;
        }
        if (i< m-1 && grid[i][j] < grid[i+1][j]) {
            dfs(grid, paths, i+1, j);
            cur = (cur + paths[i+1][j]) % 1000000007;
        }
        if (j <n-1 && grid[i][j] < grid[i][j+1]) {
            dfs(grid, paths, i, j+1);
            cur = (cur + paths[i][j+1]) % 1000000007;
        }
        paths[i][j] = cur;
        ans = (ans + cur) % 1000000007;
        // System.out.println("i: "+ i + " j: " + j + " ans: " + ans);
    }
}
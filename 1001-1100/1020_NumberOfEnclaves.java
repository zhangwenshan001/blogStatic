class Solution {
    int m;
    int n;
    int count;
    boolean flag;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int ans = 0;

        boolean[][] marked = new boolean[m][n];
        for (int i = 0;i<m;i++) {
            for (int j = 0;j<n;j++) {
                if (!marked[i][j] && grid[i][j] == 1) {
                    count = 0;
                    flag = false;
                    dfs(grid, marked, i, j);
                    if (!flag) ans += count;
                }
            }
        }
        return ans;
        
    }

    private void dfs(int[][] grid, boolean[][] marked , int i, int j) {
        if (marked[i][j]) return;
        count++;
        marked[i][j] = true;

        if (i == 0 || i == m-1 || j == 0 || j == n-1) flag = true;
        if (i > 0 && grid[i-1][j] == 1) dfs(grid, marked, i-1,j);
        if (j > 0 && grid[i][j-1] == 1) dfs(grid, marked, i, j-1);
        if (i < m-1 && grid[i+1][j] == 1) dfs(grid, marked, i+1, j);
        if (j < n-1 && grid[i][j+1]==1) dfs(grid, marked, i, j+1);

    }
}
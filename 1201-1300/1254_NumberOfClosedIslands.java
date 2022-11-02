class Solution {
    int m;
    int n;
    boolean flag;
    public int closedIsland(int[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        boolean[][] marked = new boolean[m][n];

        for (int i = 0;i<m;i++) {
            for (int j = 0;j<n;j++) {
                if (!marked[i][j] && grid[i][j] == 0) {
                    flag = true;
                    dfs(grid, marked, i, j);
                    ans += flag ? 1 : 0;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, boolean[][] marked, int i, int j)
    {
        if (i <= 0 || i >= m-1 || j<=0 || j>= n-1) {
            flag = false;
            return;
        }
        if (marked[i][j]) return;
        marked[i][j] = true;
        
        if (grid[i-1][j] == 0) dfs(grid, marked, i-1, j);
        if (grid[i+1][j] == 0) dfs(grid, marked, i+1, j);
        if (grid[i][j-1] == 0) dfs(grid, marked,i,j-1);
        if (grid[i][j+1] == 0) dfs(grid, marked, i, j+1);
    }
}
class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int sx = -1, sy = -1;
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<n;j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                    break;
                }
            }
        }
        boolean[][] marked = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        dfs(grid, marked, q, sx, sy);
        while(q.size() > 0) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (x-1 >= 0 && !marked[x-1][y]) {
                if (grid[x-1][y] == 1) return grid[x][y]-1;
                else {
                    marked[x-1][y] = true;
                    q.add(new int[]{x-1, y});
                    grid[x-1][y] = grid[x][y] + 1;
                }
            }
            if (x+1 < n && !marked[x+1][y]) {
                if (grid[x+1][y] == 1) return grid[x][y]-1;
                else {
                    marked[x+1][y] = true;
                    q.add(new int[]{x+1, y});
                    grid[x+1][y] = grid[x][y] + 1;
                }
            }
            if (y-1 >=0 && !marked[x][y-1]) {
                if (grid[x][y-1] == 1) return grid[x][y]-1;
                else {
                    marked[x][y-1] = true;
                    q.add(new int[]{x, y-1});
                    grid[x][y-1] = grid[x][y] + 1;
                }
            }
            if (y+1 < n && !marked[x][y+1]) {
                if (grid[x][y+1] == 1) return grid[x][y]-1;
                else {
                    marked[x][y+1] = true;
                    q.add(new int[]{x, y+1});
                    grid[x][y+1] = grid[x][y] + 1;
                }
            }
        }
        return -1;
    }

    private void dfs(int[][] grid, boolean[][] marked,Queue<int[]> q, int i, int j) {
        if (i<0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] == 0 || marked[i][j]) return;
        marked[i][j] = true;
        q.add(new int[]{i, j});
        dfs(grid, marked, q, i-1, j);
        dfs(grid, marked, q, i+1, j);
        dfs(grid, marked, q, i, j-1);
        dfs(grid, marked, q, i, j+1);
    }


}
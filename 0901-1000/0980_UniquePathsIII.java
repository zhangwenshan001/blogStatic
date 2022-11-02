class Solution {
    int[][] grid;
    boolean[][] marked;
    int ex, ey;
    int squareCount;
    int res;
    public int uniquePathsIII(int[][] grid) {
        int sx = 0, sy = 0;
        squareCount = 1;
        this.grid = grid;
        marked = new boolean[grid.length][grid[0].length];
        for (int i = 0;i<grid.length;i++) {
            for (int j = 0;j<grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                } else if (grid[i][j] == 0) {
                    squareCount++;
                } 
            }
        }
        backtracking(sx, sy);
        return res;
    }

    private void backtracking(int sx, int sy){
        if (sx == ex && sy == ey) {
            if (squareCount == 0) res++;
            return;
        }
        if (sx < 0 || sx >= grid.length || sy < 0 || sy >= grid[0].length ||
         grid[sx][sy] == -1 || marked[sx][sy]) return;
        
        squareCount--;
        marked[sx][sy] = true;
        //up
        backtracking(sx-1, sy);
        //down
        backtracking(sx+1, sy);
        //left
        backtracking(sx, sy-1);
        //right
        backtracking(sx, sy+1);
        squareCount++;
        marked[sx][sy] = false;
    }
}
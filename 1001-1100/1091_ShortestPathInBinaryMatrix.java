class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        if (n ==1) return grid[0][0] == 0 ? 1 : -1;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        boolean[][] marked = new boolean[n][n];
        xq.add(0);
        yq.add(0);
        marked[0][0] = true;
        int ans = 1;
        while(xq.size() > 0) {
            int size = xq.size();
            ans++;
            for (int k = 0;k<size;k++) {
                int xCur = xq.poll();
                int yCur = yq.poll();
                for (int i = -1;i<=1;i++) {
                    for (int j = -1;j<=1;j++) {
                        if (i == 0 && j == 0) continue;
                        if (xCur + i >= 0 && xCur+i <n && yCur+j >=0 && yCur+j < n && grid[xCur + i][yCur+j] == 0 && !marked[xCur + i][yCur+j]) {
                            if (xCur+i == n-1 && yCur + j == n-1) return ans;
                            marked[xCur + i][yCur + j] = true;
                            xq.add(xCur + i);
                            yq.add(yCur + j);
                        }
                    }
                }
            }
        }
        return -1;

    }
}
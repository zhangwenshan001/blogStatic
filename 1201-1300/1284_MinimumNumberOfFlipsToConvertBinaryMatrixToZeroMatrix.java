class Solution {
    int ans;
    int m;
    int n;
    public int minFlips(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        ans = -1;
        boolean[][] flip = new boolean[m][n];
        backtracking(mat, flip, 0, 0);
        return ans;
    }

    private void backtracking(int[][] mat, boolean[][] flip, int i, int j) {
        if (i == m) {
            boolean flag = true;
            int flipCount = 0;
            for (int ii = 0;ii<m;ii++) {
                for (int jj = 0;jj<n;jj++) {
                    flipCount += flip[ii][jj] ? 1 : 0;
                    int cur = 0;
                    if (ii-1 >= 0) cur += flip[ii-1][jj] ? 1 : 0;
                    if (jj-1 >= 0) cur += flip[ii][jj-1] ? 1 : 0;
                    cur += flip[ii][jj] ? 1 : 0;
                    if (ii+1 < m) cur += flip[ii+1][jj] ? 1 : 0;
                    if (jj+1 < n) cur += flip[ii][jj+1] ? 1 : 0;
                    if (cur % 2 != mat[ii][jj]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }
            if (flag) ans = ans < 0 ? flipCount : Math.min(ans, flipCount);
            return;
        }
        //flip current
        flip[i][j] = true;
        backtracking(mat, flip, j==n-1? i+1:i, j==n-1?0:j+1);
        flip[i][j] = false;
        //not flip current
        backtracking(mat, flip, j==n-1? i+1:i, j==n-1?0:j+1);
    }
}

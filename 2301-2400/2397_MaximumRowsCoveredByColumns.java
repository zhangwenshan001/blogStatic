class Solution {
    private int[][] mark;
    private int m;
    private int n;
    public int maximumRows(int[][] matrix, int numSelect) {
        m = matrix.length;
        n = matrix[0].length;
        mark = new int[m][n];

        return backTracking(matrix, numSelect, 0);
    }

    private int backTracking(int[][] matrix, int numSelect, int col) {
        int c1 = 0;
        int c2 = 0;

        // current col selected
        if (numSelect > 0) {
            // mark values at col = values at col-1
            for (int i = 0;i<m;i++) {
                mark[i][col] = (col == 0) ? 0 : mark[i][col-1];
            }
            // if last col
            if (col == n-1) {
                for (int i = 0;i<m;i++) {
                    if (mark[i][col] == 0) c1++;
                }
            } else {
                c1 = backTracking(matrix, numSelect-1, col + 1);
            }
        }

        // current col not selected
        for (int i =0;i<m;i++) {
            if (matrix[i][col] == 1 || (col > 0 && mark[i][col-1] == 1)) mark[i][col] = 1;
        }
        if (col == n-1) {
            for (int i = 0;i<m;i++) {
                if (mark[i][col] == 0) c2++;
            }
        } else {
            c2 = backTracking(matrix, numSelect, col+1);
        }

        // after all the logic, backTracking current col
        for (int i = 0;i<m;i++) {
            mark[i][col] = 0;
        }
        return Math.max(c1, c2);
    }


    
}
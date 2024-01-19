class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;

        for (int i = 0;i<matrix.length;i++) {
            for (int j = 0;j<matrix[0].length;j++) {
                if (i > 0) {
                    int curMin = matrix[i][j] + matrix[i-1][j];
                    if (j > 0) curMin = Math.min(curMin, matrix[i][j] + matrix[i-1][j-1]);
                    if (j < matrix[0].length-1) curMin = Math.min(curMin, matrix[i][j] + matrix[i-1][j+1]);
                    matrix[i][j] = curMin;
                }
                if (i == matrix.length-1) min = Math.min(min, matrix[i][j]);
            }
        }
        return min;
    }
}
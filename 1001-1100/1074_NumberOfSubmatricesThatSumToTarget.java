class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m][n];

        for (int i = 0;i<m;i++) {
            for (int j = 0;j<n;j++) {
                if (i == 0 && j == 0) sum[i][j] = matrix[i][j];
                else if (i == 0) sum[i][j] = matrix[i][j] + sum[i][j-1];
                else if (j == 0) sum[i][j] = matrix[i][j] + sum[i-1][j];
                else sum[i][j] = matrix[i][j] + sum[i-1][j]+sum[i][j-1] - sum[i-1][j-1];
            }
        }
        int count = 0;
        for (int i = 0;i<m;i++) {
            for (int j = 0;j<n;j++) {
                for (int k = i;k<m;k++) {
                    for (int p = j;p<n;p++) {
                        if (i == 0 && j == 0) count = (sum[k][p] == target) ? count+1 : count;
                        else if (i == 0) count = (sum[k][p]- sum[k][j-1] == target) ? count+1 : count;
                        else if (j == 0) count = (sum[k][p] - sum[i-1][p] == target) ? count+1 : count;
                        else count = (sum[k][p] - sum[i-1][p] - sum[k][j-1] + sum[i-1][j-1] == target)? count+1 : count;
                    }
                }
            }
        }
        return count;
    }
}
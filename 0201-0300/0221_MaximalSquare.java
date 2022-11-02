class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix== null || matrix.length ==0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] tmp = new int[m][n];
		tmp[0][0] = matrix[0][0] - '0';
		int res = tmp[0][0];
		for(int i =0;i< matrix.length;i++) {
			for(int j =0;j<matrix[0].length;j++) {
				if (matrix[i][j] == '0') {
					tmp[i][j] = 0;
				} else {
					if (i==0 && j>0) {
						tmp[i][j] = 1;
						res = Math.max(res, 1);
					} else if (j==0 && i > 0) {
						tmp[i][j] = 1;
						res = Math.max(res, 1);
					} else if (i > 0 && j>0){
						tmp[i][j] = Math.min(Math.min(tmp[i-1][j], tmp[i][j-1]), tmp[i-1][j-1]) + 1;
						res = Math.max(res, tmp[i][j]);
					}
				}
			}
		}
		return res*res;
    }
}
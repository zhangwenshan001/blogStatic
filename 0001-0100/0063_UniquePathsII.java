class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] tmp = new int[n];
        
        tmp[0] = (obstacleGrid[0][0]==0) ? 1 : 0;
        for(int j = 1;j<n;j++) {
            if (tmp[j-1] == 0 || obstacleGrid[0][j] == 1) {
                tmp[j] = 0;
            } else {
                tmp[j] = 1;
            }
        }
        
        for(int i =1;i<m;i++) {
            tmp[0] = (tmp[0] == 0 || obstacleGrid[i][0] == 1) ? 0 : 1; 
            for(int j = 1;j<n;j++) {
                tmp[j] = (obstacleGrid[i][j] == 1) ? 0 : tmp[j-1] + tmp[j];
            }
        }
        return tmp[n-1];
    }
}
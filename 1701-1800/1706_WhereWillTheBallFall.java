class Solution {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int j = 0;j<ans.length;j++) {
            int curPos = j; 
            for (int i = 0;i<grid.length;i++) {
               if (grid[i][curPos] == -1) {
                    if (curPos == 0 || grid[i][curPos-1] == 1) {
                        curPos = -1;
                        break;
                    } else {
                        curPos--;
                    }
               } else {
                    if (curPos == ans.length-1 || grid[i][curPos+1] == -1){
                        curPos = -1;
                        break;
                    } else {
                        curPos++;
                    }
               }
            }
            ans[j] = curPos;
        }
        return ans;
    }
}
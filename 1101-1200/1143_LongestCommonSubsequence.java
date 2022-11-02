class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int[][] map = new int[m][n];
        
        map[0][0] = (text1.charAt(0) == text2.charAt(0)) ? 1 : 0;
        for(int i = 1;i < m; i++) {
            map[i][0] = (map[i-1][0] == 1 || text1.charAt(i) ==  text2.charAt(0)) ? 1:0;
        }
        
        for(int j = 1;j<n;j++) {
            map[0][j] = (map[0][j-1] == 1 || text1.charAt(0) ==  text2.charAt(j)) ? 1:0;
        }
        
        for(int i =1;i<m;i++) {
            for(int j =1;j<n;j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    map[i][j] = map[i-1][j-1] + 1;
                } else {
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                }
            }
        }
        
        return map[m-1][n-1];
    }
}
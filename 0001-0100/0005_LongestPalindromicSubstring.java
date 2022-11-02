class Solution {
    public String longestPalindrome(String s) {
        if (s==null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int sLen = s.length();
        boolean[][] tmp = new boolean[sLen][sLen];
        int maxLenX = 0;
        int maxLenY = 0;
        int maxLen = 1;

        for(int j=0;j<sLen;j++) {
            tmp[j][j] = true;
            if (j>0) {
                tmp[j-1][j] = (s.charAt(j-1) == s.charAt(j));
                if (maxLen < 2 && tmp[j-1][j]) {
                    maxLenX = j-1;
                    maxLenY = j;
                    maxLen = 2;
                }
            }
            for(int i=j-2;i>=0;i--) {
                tmp[i][j] = tmp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                if (tmp[i][j] && j-i+1 > maxLen) {
                    maxLenX = i;
                    maxLenY = j;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(maxLenX,  maxLenY+1);
    }
}
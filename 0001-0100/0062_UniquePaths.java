class Solution {
    public int uniquePaths(int m, int n) {
        int[] line = new int[n];
        for (int j = 0;j<n;j++) line[j] = 1;
        for (int i = 1;i<m;i++) {
            for (int j = 1;j<n;j++) {
                line[j] = line[j-1] + line[j];
            }
        }
        return line[n-1];
    }
}
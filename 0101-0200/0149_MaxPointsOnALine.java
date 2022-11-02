class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len <= 2) return len;
        int max = 0;
        for (int i = 0;i<len-1;i++) {
            for (int j = i+1;j<len;j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int curCount = 2;
                for (int k = j+1;k<len;k++) {
                    int kdx = points[k][0] - points[j][0];
                    int kdy = points[k][1] - points[j][1];
                    if (dy * kdx == dx * kdy) curCount++;
                }
                max = Math.max(max, curCount);
            }
        }
        return max;
    }
}
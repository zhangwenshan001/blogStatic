class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {

        // Arrays.sort(points, (a, b) -> a[0] - b[0]); //lambda
        Arrays.sort(points, Comparator.comparing(p -> p[0])); //another way
        int m = 0;
        for (int i = 1;i<points.length;i++) {
            if (points[i][0] - points[i-1][0] > m) {
                m = points[i][0] - points[i-1][0];
            }
        }
        return m;
    }
    
}
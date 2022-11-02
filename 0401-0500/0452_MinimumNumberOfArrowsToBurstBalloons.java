class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] n1, int[] n2) {
                    return n1[1] - n2[1];       
            }
        });
            
        int count = 1;
        int end = points[0][1];
        for(int i = 0;i<points.length;i++) {
            if (end >= points[i][0]) {
                continue;
            }
            
            count++;
            end = points[i][1];
        }
        
        return count;
    }
}
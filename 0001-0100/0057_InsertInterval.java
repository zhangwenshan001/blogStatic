class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean flag = false;
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        if (newInterval[1] < intervals[0][0]) res.add(newInterval);

        for(int i = 0;i<intervals.length;i++) {
            if (intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]) {
                if (newInterval[1] < intervals[i][0] && i >0 && newInterval[0] > intervals[i-1][1]) flag = true;

                if (flag) {
                    res.add(newInterval);
                    flag = false;
                }
                res.add(intervals[i]);
            } else {  // between current
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                flag = true;
            }
        }

        if (flag || newInterval[0] > intervals[intervals.length-1][1]) {
            res.add(newInterval);
        }
        int[][] arr = new int[res.size()][2];
        return res.toArray(arr);
    }
}
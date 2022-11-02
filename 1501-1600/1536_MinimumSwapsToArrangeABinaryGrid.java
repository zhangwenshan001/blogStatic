class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> zeroCounts = new LinkedList<>();
        for (int i = 0;i<n;i++) {
            int zeroCount = 0, j = n-1;
            while(j >= 0 && grid[i][j--] == 0) zeroCount++;
            zeroCounts.add(zeroCount);
        }

        int res = 0;
        int needZeroCounts, row;
        for (int i = 0;i<n;i++) {
            needZeroCounts = n - i - 1;
            row = i;
            while(row < n && zeroCounts.get(row) < needZeroCounts) row++;
            if (row == n) return -1;
            res += row - i;
            int cur = zeroCounts.remove(row); 
            zeroCounts.add(i, cur);  
        }
        return res;
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for (int i = 0;i<gas.length;i++) {
            diff[i] = gas[i] - cost[i];
        }

        int total = 0;
        int cur = 0;
        int res = -1;
        for (int i = 0;i<diff.length;i++) {
            total += diff[i];
            if (cur + diff[i] < 0) {
                res = -1;
                cur = 0;
            } else {
                cur += diff[i];
                if (res == -1)res = i;
            }
        }
        if (total < 0) return -1;
        return res;
    }
}
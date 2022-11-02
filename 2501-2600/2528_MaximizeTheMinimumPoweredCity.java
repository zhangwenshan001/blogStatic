class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long left = 0, right = k;
        for (int station : stations) right += (long) station; //total counts of power stations

        int[] arrs = new int[n];
        while (left <= right) {
            for (int i = 0;i<n;i++) arrs[i] = stations[i]; //initialize

            long mid = (left + right) / 2; // suppose result is mid, check if it is okay
            long curPower = 0, use = 0;
            for (int i = 0;i<r;i++) curPower += arrs[i];

            for (int i = 0;i<n;i++) {
                if (i+r <n) curPower += arrs[i + r];
                if (i-r-1 >= 0) curPower -= arrs[i-r-1];
                if (curPower < mid) {
                    int pos = Math.min(i+r, n-1);
                    arrs[pos] += mid - curPower;
                    use += mid - curPower;
                    curPower = mid;
                    if (use > k) break;
                }
            }
            if (use > k) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}
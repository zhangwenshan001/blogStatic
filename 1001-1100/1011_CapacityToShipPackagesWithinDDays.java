class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int max = Integer.MIN_VALUE;

        int[] sums = new int[weights.length];
        for (int i = 0;i<weights.length;i++) {
            max = Math.max(max, weights[i]);
            sums[i] = (i ==0) ? weights[i] : sums[i-1] + weights[i];
        }

        int low = max;
        int high = 25000000;
        while (low < high) {
            int mid = (low + high) / 2;
            if (needDays(sums, mid) > days) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int needDays(int[] sums, int capacity) {
        int day = 0;
        int preLast = -1;
        for (int i = 0;i<sums.length;i++) {
            if (preLast < 0) {
                if (sums[i] > capacity) {
                    day++;
                    preLast = i-1;
                }
            } else {
                if (sums[i] - sums[preLast]> capacity) {
                    day++;
                    preLast = i-1;
                }
            }
        }
        return day+1;
    }
}
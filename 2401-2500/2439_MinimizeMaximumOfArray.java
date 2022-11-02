class Solution {
//    public int minimizeArrayValue(int[] nums) {
//        int preMaxAvg = nums[0];
//        long sum = nums[0];
//        int avg = nums[0];
//        int minMax = nums[0];
//        for (int i = 1;i<nums.length;i++) {
//            sum += nums[i];
//            avg = (int)(sum / (i+1));
//            if (nums[i] <= preMaxAvg) continue;
//            if (avg >= preMaxAvg) {
//                preMaxAvg = avg;
//                minMax = Math.max(minMax, sum == (long)(i+1) * (long)avg ? avg :avg+1);
//            }
//        }
//        return minMax;
//    }

    public int minimizeArrayValue(int[] nums) {
        int preMaxAvg = nums[0];
        int avg = nums[0];
        int minMax = nums[0];
        int remain = 0;
        for (int i = 1;i<nums.length;i++) {
            int diff = (nums[i] + remain - avg) / (i+1);
            avg = avg + diff;
            remain = nums[i] + remain - diff * i - avg;
            if (nums[i] <= preMaxAvg) continue;
            if (avg >= preMaxAvg) {
                preMaxAvg = avg;
                minMax = Math.max(minMax, remain == 0 ? avg : avg + 1);
            }
        }
        return minMax;

    }
}
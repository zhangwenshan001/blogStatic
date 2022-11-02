class Solution {
    int[] sums;
    public boolean PredictTheWinner(int[] nums) {
        sums = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
           sums[i] = (i == 0) ? nums[0] : nums[i] + sums[i-1]; 
        }

        int max = maxScore(nums, 0, nums.length-1);
        if (max >= sums[nums.length-1] - max) return true;
        return false;
    }

    private int maxScore(int[] nums, int start, int end) {
        if (start == end) return nums[start];

        int total = (start == 0) ? sums[end] : sums[end] - sums[start-1];

        // if choose start
        int chooseStartLost = maxScore(nums, start + 1, end);
        int chooseStartGot =  total - chooseStartLost;

        // if choose end
        int chooseEndLost = maxScore(nums, start, end - 1);
        int chooseEndGot =  total - chooseEndLost;

        return Math.max(chooseStartGot, chooseEndGot);
    }
}
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] sum = new int[nums.length];
        for (int i = 0;i<nums.length;i++) {
            sum[i] = i == 0 ? nums[i] : sum[i-1] + nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0;i<nums.length;i++) {
            res[i] = (i == 0) ? sum[nums.length-1] - sum[i] + (2*i+1-nums.length) * nums[i] : sum[nums.length-1] - sum[i] + (2*i+1-nums.length) * nums[i] - sum[i-1];
        }

        return res;
    }
}
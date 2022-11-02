class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] memo = new int[nums.length]; // maxLen
        int[] counts = new int[nums.length]; // maxCount

        Arrays.fill(memo, 1);
        Arrays.fill(counts, 1);

        int maxLen = 1;
        int count = 1;
        for (int i = 1;i<nums.length;i++) {
            for (int j = 0;j<i;j++) {
                if (nums[i] > nums[j]) {
                    if (memo[j] + 1 > memo[i]) {
                        memo[i] = memo[j] + 1;
                        counts[i] = counts[j];
                    } else if (memo[j] + 1 == memo[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            if (memo[i] > maxLen) {
                count = counts[i];
                maxLen = memo[i];
            } else if (memo[i] == maxLen) {
                count += counts[i];
            }
        }
        return count;
    }
}
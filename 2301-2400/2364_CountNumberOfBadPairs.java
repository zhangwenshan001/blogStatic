class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0;i<n;i++) {
            count.put(nums[i] - i, count.getOrDefault(nums[i] - i, 0) + 1);
        }
        long total = (long)n * (long)(n-1) / 2;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int val = entry.getValue();
            if (val >= 2) total -= (long)(val-1) * (long)val / 2;
        }
        return total;

    }
}
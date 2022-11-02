class Solution {
    public long minCost(int[] nums, int[] cost) {
        int start = 1000000;
        int end = 1;
        for (int i : nums) {
            start = Math.min(start, i);
            end = Math.max(end, i);
        }
        
        Long res = getCosts(nums, cost, start);
        while (start < end) {
            int mid = ((end + start) / 2);
            long midCosts = getCosts(nums, cost, mid);
            long nextCosts = getCosts(nums, cost, mid+1);
            if (nextCosts < midCosts) { // min is in right side
                start = mid+1;
            } else { // 
                end = mid;
            }
            res = Math.min(midCosts, nextCosts);
        }
        return res;
    }

    private long getCosts(int[] nums, int[] cost, int k)
    {
        Long res = (long)0;
        for (int i = 0;i<nums.length;i++) {
            res += (long)(Math.abs(k-nums[i])) * cost[i];
        }
        return res;
    }
}
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) sum += num;
        int r = sum - x;
        if (r < 0) return -1;
        int l = 0;
        int s = 0;
        int ans = -1;
        for (int i = 0;i<nums.length;i++) {
            s += nums[i];
            while(s > r) s -= nums[l++];
            if (s == r) {
                ans = ans < 0 ? nums.length - (i - l + 1) : Math.min(ans, nums.length - (i - l + 1));
            } 
        }
        return ans;
    }
}
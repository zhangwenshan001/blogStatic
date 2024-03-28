class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        while(left < nums.length && nums[left] >= k) left++;
        if (left >= nums.length) return 0;
        int ans = 0;
        int right = left;
        int product = 1;
        while(right < nums.length) {
            while (product * nums[right] >= k && left < right) {
                product /= nums[left++];
            }

            product *= nums[right++];
            if (product < k) ans += right-left;
        }

        return ans;
    }
}
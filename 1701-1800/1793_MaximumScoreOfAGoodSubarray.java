class Solution {
    public int maximumScore(int[] nums, int k) {
        int[] min = new int[nums.length];
        min[k] = nums[k];
        for (int j = k-1;j>=0;j--) {
            min[j] = Math.min(nums[j], min[j+1]);
        }
        for (int j = k+1;j<nums.length;j++) {
            min[j] = Math.min(nums[j], min[j-1]);
        }

        int ans = 0;
        int j = nums.length-1;
        for (int i = 0;i<=k;i++) {
            while(min[j] < min[i]) {
                ans = Math.max(ans, min[j] * (j-i+1));
                j--;
            }
            ans = Math.max(ans, min[i] * (j-i+1));
        }
        return ans;
    }
}
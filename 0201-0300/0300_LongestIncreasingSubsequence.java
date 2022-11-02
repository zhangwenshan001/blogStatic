class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] c = new int[nums.length];
        Arrays.fill(c, 1);
        int ans = 1;
        for (int i = 1;i<nums.length;i++) {
            for (int j = i-1;j>=0;j--) {
                if (nums[i] > nums[j]) c[i] = Math.max(c[i], c[j]+1);
            }
            ans = Math.max(ans, c[i]);
        }
        return ans;
    }
}
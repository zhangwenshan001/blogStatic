class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] ans = new int[nums.length / 3][3];

        Arrays.sort(nums);
        for (int i = 0;i<nums.length;i++) {
            int r = i / 3;
            int c = i % 3;
            ans[r][c] = nums[i];
            if (ans[r][c] - ans[r][0] > k) return new int[0][];
        }
        return ans;
    }
}
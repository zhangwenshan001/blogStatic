class Solution {
    public int xorBeauty(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
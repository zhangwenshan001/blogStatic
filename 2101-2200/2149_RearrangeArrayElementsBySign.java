class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pArr = new int[nums.length / 2];
        int[] nArr = new int[nums.length / 2];
        int i = 0;
        int j = 0;
        for (int num : nums) {
            if (num > 0) pArr[i++] = num;
            else nArr[j++] = num;
        }
        int[] ans = new int[nums.length];
        for (int k = 0;k<nums.length / 2;k++) {
            ans[2 * k] = pArr[k];
            ans[2 * k + 1] = nArr[k];
        }

        return ans;
    }
}
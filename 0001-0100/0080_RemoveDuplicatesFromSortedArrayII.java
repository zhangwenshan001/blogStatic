class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int curCount = 0;
        for (int j = 0;j<nums.length;j++) {
            if (j == 0 || curCount == 2 && nums[j] != nums[j-1] || curCount == 1 && nums[j] != nums[j-1]) {
                nums[i++] = nums[j];
                curCount = 1;
                continue;
            }

            if (curCount == 1 && nums[j] == nums[j-1]) {
                nums[i++] = nums[j];
                curCount = 2;
            }

        }
        return i;
    }
}
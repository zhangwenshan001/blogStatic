class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        int j = nums.length-1;

        //nums.length will always be odd

        while(i < j) {
            int mid = (i + j) / 2;
            int halfLength = (j - i) / 2;
            if (halfLength % 2 == 0) {
                if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid +1]) return nums[mid];
                if (nums[mid] == nums[mid-1]) {
                    j = mid;
                } else {
                    i = mid;
                }
            } else {
                // if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid +1]) return nums[mid];
                if (nums[mid] == nums[mid-1]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }

        return nums[i];
    }
}
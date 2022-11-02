class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeftRange(nums,target), searchRightRange(nums, target)};
    }

    private int searchLeftRange(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] == target && (mid == 0 || nums[mid-1] < target)) {
                return mid;
            } else {
                j = mid - 1;
            }
        }
        return nums[i] == target ? i : -1;
    }

    private int searchRightRange(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int i = 0;
        int j = nums.length-1;
        while(i < j) {
            int mid = (i+j) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] == target && (mid == nums.length-1 || nums[mid+1] > target)) {
                return mid;
            } else {
                i = mid + 1;
            }
        }
        return nums[i] == target ? i : -1;
    }
}
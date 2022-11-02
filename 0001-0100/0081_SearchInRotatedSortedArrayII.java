class Solution {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    private boolean binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) return false;
        if (start == end) return nums[start] == target;

        int mid = (start + end) / 2;
        if (nums[mid] == target) return true;

        if (nums[start] == nums[mid]) {
            if (nums[end] == nums[mid]) {
                return binarySearch(nums, target, start, mid-1) || binarySearch(nums, target, mid + 1, end);
            }
            if (nums[end] > nums[mid]) {
                if (target < nums[mid]) return false;
                return binarySearch(nums, target, mid + 1, end);
            }
            if (nums[end] < nums[mid]) {
                return binarySearch(nums, target, mid + 1, end);
            }
        }

        if (nums[start] > nums[mid]) {
            if (nums[end] == nums[mid]) {
                return binarySearch(nums, target, start, mid - 1);
            }
            if (nums[end] > nums[mid]) {
                if (target <=  nums[end]) return binarySearch(nums, target, start, mid - 1) || binarySearch(nums, target, mid+1, end);
                return binarySearch(nums, target, start, mid - 1);
            }
        }

        if (nums[start] < nums[mid]) {
            if (nums[mid] == nums[end]) {
                return binarySearch(nums, target, start, mid-1);
            }
            if (nums[mid] > nums[end]) {
                if (target >= nums[start] && target < nums[mid]) return binarySearch(nums, target, start, mid-1);
                return binarySearch(nums, target, mid + 1, end);
            }
            if (nums[mid] < nums[end]) {
                if (target > nums[mid]) return binarySearch(nums, target, mid + 1, end);
                return binarySearch(nums, target, start, mid-1);
            }
        }
        return false;
    }
}
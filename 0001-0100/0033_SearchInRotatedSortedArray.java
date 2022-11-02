class Solution {
    public int search(int[] nums, int target) {
     if (nums.length ==1) {
            return (target == nums[0]) ? 0 : -1;
        }
        int start = 0;
        int end = nums.length - 1;
        
        int middle = (start + end) / 2;
        while(start < end) {
            if (nums[middle] == target) {
                return middle;
            }else if (start+1 == end && target!=nums[start] && target!=nums[end]) {
                break;
            } else if (nums[start] == target) {
                return start;
                
            } else if (nums[end] == target){
                return end;
            }else if ((nums[start] < nums[end] && target < nums[middle] && target >= nums[start]) ||
                    (nums[start] > nums[end] && nums[start] > nums[middle] && (target>=nums[start]||target<nums[middle])) ||
                    (nums[start] < nums[middle] && nums[start] > nums[end] && target >= nums[start] && target < nums[middle])) {
                end = middle;
                middle = (start + end) / 2;
            } else if ((nums[start] < nums[end] && target > nums[middle] && target <= nums[end]) ||
                    (nums[start] > nums[end] && nums[start] > nums[middle] && target <= nums[end] && target> nums[middle]) ||
                    (nums[start] < nums[middle] && nums[start] > nums[end] &&  (target <= nums[end]||target>nums[middle]))) {
                start = middle;
                middle = (start + end) / 2;
            } else {
                break;
            }
        }
        
        return -1;
    }
}
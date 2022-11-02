class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstIndex = -1, secondIndex = -1;
        for (int i = 0;i<nums.length;i++) {
            if (firstIndex < 0) {
                firstIndex = i;
                continue;
            } else if (secondIndex < 0) {
                if (nums[i] > nums[firstIndex]) secondIndex = i;
                else firstIndex = i;
            } else {
                if (nums[i] > nums[secondIndex]) return true;
                else if (nums[i] > nums[firstIndex]) secondIndex = i;
                else firstIndex = i;
            }
        }
        return false;
    }
}
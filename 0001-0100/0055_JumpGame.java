class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0){
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int cur = 0;
        int indexMax = nums[cur];
        while(cur<=indexMax) {
            if(cur == indexMax && nums[cur] == 0) {
                return false;
            }
            indexMax = Math.max(cur+nums[cur], indexMax);
            if (indexMax >= nums.length-1) {
                return true;
            }
            cur++;
        }
        return false;
    }
}
class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 1;i<nums.length && cnt < 2;i++) {
            if (nums[i] >= nums[i-1]) {
                continue;
            }
            cnt++;
            
            if (i<=1 || nums[i] >= nums[i-2]) {
                nums[i-1] = nums[i];
            } else {
                nums[i] = nums[i-1];
            }
        
        }
        
        return cnt<=1;
    }
}
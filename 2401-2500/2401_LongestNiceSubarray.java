class Solution {
    public int longestNiceSubarray(int[] nums) {
        int pre = 0;
        int num = nums[0]; 
        int maxLength = 1;
        for (int i = 1;i<nums.length;i++) {
            //remove pre nums until num & nums[i] = 0
            while(pre < i && (num & nums[i]) != 0) {
                num = num ^ nums[pre++];
            }

            num = num ^ nums[i];
            maxLength = Math.max(maxLength, i-pre+1);
        }
        return maxLength;
    }
}
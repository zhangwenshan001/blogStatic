class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) return;
        reverse(nums, 0, len-1-k); 
        reverse(nums,len-k, len-1);
        reverse(nums,0, len-1);
    }

    public void reverse(int[]nums, int start, int end)
    {
        for(;start<end;start++,end--) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }
}
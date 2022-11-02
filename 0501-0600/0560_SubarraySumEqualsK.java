class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int l = nums.length;
        
        int count = 0;
        
        int[] tmp = new int[l];
        for(int i = 0;i<l;i++) {
            tmp[i] = nums[i];
            if (tmp[i] == k) {
                count++;
            }
            for(int j = i+1;j<l;j++) {
                tmp[j] = tmp[j-1] + nums[j];
                if (tmp[j] == k) {
                    count++;
                }  
            }
        }   
        return count;
    }
}
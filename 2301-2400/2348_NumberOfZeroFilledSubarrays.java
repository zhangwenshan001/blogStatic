class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long c = 0;
        Boolean flag = false;
        for(int i = 0;i<nums.length;i++) {
            if ((nums[i]!=0 && flag) || i == nums.length-1) {
                if (nums[i]==0) {
                    c++;
                }
                flag = false;
                res += (1+c) * c/2;
                c = 0;
                continue;
            }
            if (nums[i] == 0 && !flag) {
                c++;
                flag = true;
                continue;
            }
            if (nums[i] == 0 && flag) {
                c++;
            }
        }
        
        return res;
    }
}

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        
        int base = 0;
        
        for (int i = 1;i<n;i++) {
            sums[i] = sums[i-1] + nums[i];
            base = base + i * nums[i];
        }
        int sum = sums[n-1];
        
        int maxdiff = 0;
        for (int i =1;i<n;i++) {
            int diff = n * sums[i-1] - i * sum;
            if (diff > maxdiff) {
                maxdiff = diff;
            }
        }
        return base + maxdiff;
    }
}

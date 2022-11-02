class Solution {
    int ans = -1;
    public int minOperations(int[] nums) {
        backTracking(nums, 0);
        return ans;
    }
    
    private void backTracking(int[] nums, int count) {
        for(int num : nums) System.out.print(num + " ");
        System.out.println();
        boolean allSame = true;
        for (int i = 0;i<nums.length-1;i++) {
            if (nums[i] != nums[i+1]) {
                allSame = false;
                break;
            }
        }
        if (allSame && nums[0] != 1) return;
        for (int i = 0;i<nums.length-1;i++) {
            int gcd = gcd(nums[i], nums[i+1]);
            if (gcd == 1) {
                ans = ans < 0 ? count + nums.length : Math.min(ans,count + nums.length);
                return;
            }
            int tmp = nums[i];
            if (tmp != gcd) {
                nums[i] = gcd;
                backTracking(nums, count+1);
                nums[i] = tmp;
            }
            tmp = nums[i+1];
            if (tmp != gcd) {
                nums[i+1] = gcd;
                backTracking(nums, count+1);
                nums[i+1] = tmp;
            }
        }
    }
    
    private int gcd(int a, int b) {
        int s = Math.min(a,b);
        int l = Math.max(a, b);
        if (l % s == 0) return s;
        for (int j = s/2;j>=1;j++) {
            if (l % j == 0 && s % j == 0) return j;
        }
        return -1;
    }
}
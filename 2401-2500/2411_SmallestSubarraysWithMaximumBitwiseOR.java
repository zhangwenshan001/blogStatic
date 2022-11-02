class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] lastBit = new int[30];
        int[] res = new int[n];
        for (int i = n-1;i>=0;i--) {
            int max = 1;
            for (int j = 0;j<30;j++) {
                // if current bit is 1
                if (((nums[i] >> j) & 1) == 1) {
                    lastBit[j] = i;
                } else if (lastBit[j] > 0) {
                    max = Math.max(max, lastBit[j] - i + 1);
                }
            }
            res[i] = max;
        } 
        return res;
    }

}
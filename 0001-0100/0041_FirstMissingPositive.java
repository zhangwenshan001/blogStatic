class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (length < 1) {
            return 1;
        }
        int[] flagArray = new int[length];

        for (int i : nums) {
            if (i<1 || i>length) {
                continue;
            }
            else {
                flagArray[i-1] = 1;
            }
        }

        for (int i =0;i<length;i++) {
            if (flagArray[i] != 1) {
                return i+1;
            }
        }

        return length+1;
    }
}
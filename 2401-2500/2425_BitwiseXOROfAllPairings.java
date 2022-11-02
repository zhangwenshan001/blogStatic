class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        if (nums1.length % 2 == 0 && nums2.length % 2 ==0) return 0;
        int xorRes1 = 0;
        int xorRes2 = 0;
        if (nums1.length % 2 != 0) {
            for(int i : nums2) xorRes2 = xorRes2^i;
        }
        if (nums2.length % 2 != 0) {
            for(int i : nums1) xorRes1 = xorRes1^i;
        }
        return xorRes1 ^ xorRes2;
    }
}
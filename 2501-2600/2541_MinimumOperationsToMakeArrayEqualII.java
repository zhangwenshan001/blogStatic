class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            for (int i =0;i<nums1.length;i++) {
                if (nums1[i] != nums2[i]) return -1;
            }
            return 0;
        }
        long ldiff = 0;
        long sdiff = 0;
        for (int i =0;i<nums1.length;i++) {
            if (nums1[i] - nums2[i] > 0) {
                if ((nums1[i] - nums2[i]) % k != 0) return -1;
                ldiff += (nums1[i] - nums2[i]) / k;
            }
            if (nums1[i] - nums2[i] < 0) {
                if ((nums2[i] - nums1[i]) % k != 0) return -1;
                sdiff += (nums2[i] - nums1[i]) / k;
            }
        }
        if (ldiff != sdiff) return -1;
        return ldiff;
    }
}
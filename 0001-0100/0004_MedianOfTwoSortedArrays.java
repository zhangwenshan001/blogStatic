class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int idx1 = -1;
        int idx2 = -1;
        for (int i = 0;i<(m+n+1)/2;i++) {
            if (idx2 == n-1 || idx1 != m - 1 && nums1[idx1+1] <= nums2[idx2 + 1]) idx1++;
            else idx2++;
        }

        int n1 = idx2 < 0 || idx1 >= 0 && nums1[idx1] >= nums2[idx2] ? nums1[idx1] : nums2[idx2];
        if ((m + n) % 2 == 1) {
            return (double)n1;
        }
        
        int n2;
        if (idx2 == n-1 || idx1 != m-1 && nums1[idx1+1] <= nums2[idx2 + 1]) n2 = nums1[idx1+1];
        else n2 = nums2[idx2+1];
        return (double) (n1 + n2) / 2;
    }
}
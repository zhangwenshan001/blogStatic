class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0;i<n;i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
        }
        int res = Math.max(sum1, sum2);

        int max1 = 0; // the max diff that nums1 can add
        int max2 = 0; //the max diff that nums2 can add
        int first = 0; 
        int second = 0;
        for (int i = 0;i<n;i++) {
            first += nums2[i] - nums1[i]; // if swap current num, nums1 can add first
            second += nums1[i] - nums2[i];

            max1 = Math.max(max1, first);
            max2 = Math.max(max2, second);

            if (first < 0) first = 0; //if first < 0, then for nums1 it's better not to swap the elements before
            if (second < 0) second = 0; //if second < 0, then for nums2 it's better not to swap the elements before
        }

        res = Math.max(res, max1+sum1);
        res = Math.max(res, max2+sum2);
        return res;
    }
}
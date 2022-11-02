class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer, Integer> nums12Map = new HashMap<Integer, Integer>();
        int tmp;
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++) {
                tmp = nums1[i] + nums2[j];
                nums12Map.put(tmp, nums12Map.getOrDefault(tmp, 0)+1);
            }
        }
        int res = 0;
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++) {
                tmp = nums3[i] + nums4[j];
                res += nums12Map.getOrDefault(-tmp, 0);
            }
        } 
        return res;

    }

}
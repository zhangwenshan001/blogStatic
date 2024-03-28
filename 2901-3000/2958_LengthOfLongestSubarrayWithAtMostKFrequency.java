class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int max = 0;

        while(right < nums.length) {
            int curFreq = map.getOrDefault(nums[right], 0);
            if (curFreq >= k) {
                while(left < right && nums[left] != nums[right]) {
                    map.put(nums[left], map.get(nums[left])-1);
                    left++;
                }
                left++;
            } else {
                map.put(nums[right], curFreq + 1);
            }
            right++;
            max = Math.max(max, right-left);
        }
        return max;
    }
}
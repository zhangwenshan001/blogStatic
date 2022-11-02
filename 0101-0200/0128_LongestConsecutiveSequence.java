class Solution {
    public int longestConsecutive(int[] nums) {
       Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = 0;
		int left, right;
		for(int i = 0;i<nums.length;i++) {
			if (!map.containsKey(nums[i])) {
				left = map.getOrDefault(nums[i]-1, 0);
				right = map.getOrDefault(nums[i] + 1, 0);
			
				res = Math.max(res, left+right+1);
				map.put(nums[i], left+right+1);

					map.put(nums[i]-left, left+right+1);
					map.put(nums[i]+right, left+right+1);

			}
		}
		return res;
    }
}
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return 0;
		}
		int n = nums.length;
		int head = nums[0];
		int lastHead = 0;
		int count = 1;
        if (head >=n-1) {
			return 1;
		}
		for(int i =1;i<n;i++) {
			if (i+nums[i] > head) {
				if (i > lastHead) {
					count++;
					lastHead = head;
				}
				head = i + nums[i];
			}
			if (head>=n-1) {
				return count;
			}
		}

		return -1;
    }
}
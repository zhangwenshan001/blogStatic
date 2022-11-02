class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
		int end = nums.length-1;

		while(true) {
			int base = nums[start];
			int i = start;
			int j = end;

			while(i < j) {
				while (i<j && nums[j] < base) {
					j--;
				}
				while(i<j && nums[i] >= base) {
					i++;
				}
				nums[start] = nums[j];
				nums[j] = nums[i];
				nums[i] = nums[start]; //swap  nums[i] nums[j]
			}

			nums[i] = base;
			if (i == k - 1) {
				return nums[i];
			} else if (i < k-1) {
					start = i+1;
			} else {
				end = i-1;
			}
		}
    }
}
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
		int end = nums.length - 1;

		boolean startFlag = false;
		boolean endFlag = false;
		while (start < end && !(startFlag && endFlag)) {
			for (int i = start;i <= end;i++) {
				if (!startFlag && nums[i] < nums[start]) {
					startFlag = true;
					break;
				}
				
			}
			if (!startFlag) {
				start++;
			}
			
			for (int j = end;j>=start;j--) {
				if (!endFlag && nums[j] > nums[end]) {
					endFlag = true;
					break;
				}
			}
			
			if (!endFlag) {
				end--;
			}
		}
		if (start == end) {
			return 0;
		}
		return end-start+1;
    }
}
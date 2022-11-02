class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      if (nums== null || nums.length<3) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for(int start = 0;start < nums.length-2;start++) {
            if (start > 0 && nums[start]==nums[start-1]) {
                continue;
            }
            for(int end = nums.length-1;end>start;end--) {
                if (end<nums.length-1 && nums[end] == nums[end+1]) {
                    continue;
                }
                find(nums, start, end, res);
            }
        }

        return res;
    }
    public void find(int[] nums, int start, int end, List<List<Integer>> res) {
        int i = start + 1;
        int j = end - 1;
        if (i>j) {
            return;
        }
        int m = (i+j) /2;
        while(i<j) {
            if (nums[m] == -nums[start] - nums[end]) {
                List<Integer> curRes = new ArrayList<>();
                curRes.add(nums[start]);
                curRes.add(nums[m]);
                curRes.add(nums[end]);
                res.add(curRes);
                return;
            } else if (nums[m] > -nums[start] - nums[end]) {
                j = m-1;
                m = (i + j) /2;
            } else {
                i = m+1;
                m = (i+j) /2;
            }
        }
        if (m!=start && m != end && nums[m] == -nums[start] - nums[end]) {
            List<Integer> curRes = new ArrayList<>();
            curRes.add(nums[start]);
            curRes.add(nums[m]);
            curRes.add(nums[end]);
            res.add(curRes);
        }

        return;

    }
}
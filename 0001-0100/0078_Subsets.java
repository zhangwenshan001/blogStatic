class Solution {
    List<List<Integer>> res;
    List<Integer> cur;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        cur = new ArrayList<>();
        helper(nums, 0);
        return res;
    }

    private void helper(int[] nums, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        // not choose current one;
        helper(nums, i+1);

        // choose current one
        cur.add(nums[i]);
        helper(nums, i+1);
        cur.remove(cur.size()-1);
    }
}
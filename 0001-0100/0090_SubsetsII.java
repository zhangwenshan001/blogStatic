class Solution {
    List<List<Integer>> res;
    List<Integer> cur;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        cur = new ArrayList<>();
        helper(nums, 0, false);
        return res;
    }

    private void helper(int[] nums, int i, boolean preChoose) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // not choose current
        helper(nums, i+1, false);

        // will not choose current if pre is not chosen and current = pre
        if (i > 0 && nums[i] == nums[i-1] && !preChoose) return;

        //choose current
        cur.add(nums[i]);
        helper(nums, i+1, true);
        cur.remove(cur.size()-1);
    }
}
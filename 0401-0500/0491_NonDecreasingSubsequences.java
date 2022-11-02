class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        backTracking(nums, res, 0, ans);
        return res;
    }

    public void backTracking(int[] nums, List<List<Integer>> res, int i, List<Integer> ans) 
    {
        if (i >= nums.length) {
            if (ans.size() >= 2) res.add(new ArrayList<Integer>(ans));
            return;
        }

        //add current int
        if (ans.size() == 0 || nums[i] >= ans.get(ans.size()-1)) {
            ans.add(nums[i]);
            backTracking(nums,res, i+1, ans);
            ans.remove(ans.size()-1);
        }

        // suppose nums[i] == nums[j]
        // current case: select i without j 
        // is the same with case: select j without i, which has already been contained before (19th row)
        if (ans.size() > 0 && ans.get(ans.size()-1) == nums[i]) return;

        // skip current int
        backTracking(nums, res, i+1, ans);
    } 

}
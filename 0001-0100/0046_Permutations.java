class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return ans;
    }

    private void backtrack(int [] nums){
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int num : nums) {
            if (cur.contains(num)) continue;
            cur.add(num);
            backtrack(nums);
            cur.remove(cur.size()-1);
        }
    }    
}
class Solution {
    public int longestArithSeqLength(int[] nums) {
        List<Map<Integer, Integer>> memo = new ArrayList<>();
        int ans = 0;
        for(int i = 0;i<nums.length;i++) memo.add(new HashMap<Integer, Integer>());

        for (int i = 0;i<nums.length;i++) {
            for (int j = 0;j<i;j++) {
                int diff = nums[i] - nums[j];
                int count = memo.get(j).getOrDefault(diff, 0);
                int cur = memo.get(i).getOrDefault(diff, 0);
                int max = Math.max(cur, count==0 ? 2 : count+1);
                ans = Math.max(ans, max);
                memo.get(i).put(diff, max);
            }
        }

        return ans;
    }
}

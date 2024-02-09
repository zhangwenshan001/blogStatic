class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[][] memo = new int[nums.length][2];
        int idx = 0;
        for (int i = 0;i<nums.length;i++) {
            memo[i] = new int[]{1, -1};
            for (int j = i-1;j>=0;j--) {
                if (nums[i] % nums[j] == 0) {
                    if (memo[j][0] + 1 > memo[i][0]) {
                        memo[i] = new int[]{memo[j][0] + 1, j};
                        if (memo[i][0] > memo[idx][0]) idx = i;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(true) {
            ans.add(nums[idx]);
            idx = memo[idx][1];
            if (idx < 0) break;
        }
        return ans;
    }
}
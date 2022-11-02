class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int val = entry.getValue();
            ans += val * (val-1) / 2;
        }
        return ans;
    }
}
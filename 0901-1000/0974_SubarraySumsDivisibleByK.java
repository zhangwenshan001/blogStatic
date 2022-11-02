class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] mods = new int[nums.length];
        int cur = 0;
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        for (int i = 0;i<nums.length;i++) {
            cur = (cur + nums[i] % k + k) % k;
            res += count.getOrDefault(cur, 0);
            count.put(cur, count.getOrDefault(cur, 0)+1);
        }
        return res;
    }
}
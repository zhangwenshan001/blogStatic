class Solution {
    // count % 3 = 0 -> count/ 3
    // count % 3 = 1 -> count / 3 + 1
    // count % 3 = 2 -> count / 3 + 1
    public int minOperations(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) counts.put(num, counts.getOrDefault(num, 0) + 1);
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int c = entry.getValue();
            if (c == 1) return -1;
            if (c % 3 == 0) ans += c / 3;
            else ans += c / 3 + 1;
        }
        return ans;
    }
}



class Solution {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> ncount = new HashMap<>();
        Map<Integer, Integer> min = new HashMap<>();

        int r;
        int maxCount = 0;
        for (int i : nums) {
            r = i % space;
            if (ncount.containsKey(r)) {
                maxCount = Math.max(maxCount, ncount.get(r) + 1);
                ncount.put(r, ncount.get(r) + 1);
                min.put(r, Math.min(i, min.get(r)));
            } else {
                maxCount = Math.max(maxCount,1);
                ncount.put(r, 1);
                min.put(r, i);
            }
        }
        int minVal = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry: ncount.entrySet()) {
            int val = entry.getValue();
            int key = entry.getKey();
            if (val == maxCount) {
                minVal = Math.min(minVal, min.get(key));
            }
        }
        return minVal;
    }
}
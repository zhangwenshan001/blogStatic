class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> nums = new HashSet<>();
        for (int[] pair : adjacentPairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new ArrayList<Integer>());
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new ArrayList<Integer>());
            }
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);

            if (nums.contains(pair[0])) nums.remove(pair[0]);
            else nums.add(pair[0]);

            if (nums.contains(pair[1])) nums.remove(pair[1]);
            else nums.add(pair[1]);
        }

        int[] ans = new int[adjacentPairs.length+1];
        int i = 0;
        for (int n : nums) {
            ans[i] = n;
            i = adjacentPairs.length;
        }

        for (i = 1;i<adjacentPairs.length;i++) {
            List<Integer> preAdj = map.get(ans[i-1]);
            ans[i] = preAdj.size() == 1 ? preAdj.get(0) : 
            (preAdj.get(0) == ans[i-2] ? preAdj.get(1) : preAdj.get(0));
        }
        return ans;
    }
}
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losts = new TreeMap<>();
        for (int[] match : matches) {
            losts.put(match[0], losts.getOrDefault(match[0], 0));
            losts.put(match[1], losts.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : losts.entrySet()) {
            if (entry.getValue() <= 1) ans.get(entry.getValue()).add(entry.getKey());
        }

        return ans;
    }
}
class Solution {
    int[] parents;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(i, new ArrayList<Integer>());
        for (int[] edge : edges) {
            if (vals[edge[0]] >= vals[edge[1]]) adj.get(edge[0]).add(edge[1]);
            else adj.get(edge[1]).add(edge[0]);
        }

        TreeMap<Integer, List<Integer>> sameValueNodes = new TreeMap<>();
        for (int i = 0;i<n;i++) {
            if (!sameValueNodes.containsKey(vals[i])) sameValueNodes.put(vals[i], new ArrayList<Integer>());
            sameValueNodes.get(vals[i]).add(i);
        }

        parents = new int[n];
        Arrays.fill(parents, -1);

        int ans = 0;
        // key will be sorted
        for (Map.Entry<Integer, List<Integer>> entry : sameValueNodes.entrySet()) {
            for (int i : entry.getValue()) {
                for (int k : adj.get(i)) { 
                    union(i, k);
                }
            }

            ans += entry.getValue().size();

            Map<Integer, Integer> group = new HashMap<>();
            for (int i : entry.getValue()) {
                group.put(find(i), group.getOrDefault(find(i), 0) + 1);
            }

            for (Map.Entry<Integer, Integer> groupEntry :group.entrySet()) {
                int count = groupEntry.getValue();
                ans += (count-1) * count / 2;
            }
        }
        return ans;
    }

    private int find(int p) {
        while(parents[p] >= 0) {
            p = parents[p];
        }
        return p;
    }

    private void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (parents[pa] <= parents[pb]) {
            parents[pa] += parents[pb];
            parents[pb] = pa;
        } else {
            parents[pb] += parents[pa];
            parents[pa] = pb;
        }
    }
}
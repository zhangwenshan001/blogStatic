class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0;i<n;i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0;i<edges.length;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] res = new int[n];
        boolean[] marked = new boolean[n];

        dfs(adj, marked, 0, res, labels);
        return res;
    }

    private int[] dfs(Map<Integer, List<Integer>> adj, boolean[] marked, int i, int[] res, String labels) {

        if (marked[i]) return null;
        marked[i] = true;
        int[] labelsCount = new int[26];

        for (int k : adj.get(i)) {
            if (!marked[k]) {
                int[] tmp = dfs(adj, marked, k, res, labels);
                for (int j = 0;j<26;j++) labelsCount[j] += tmp[j];
            }
        }

        labelsCount[labels.charAt(i) - 'a']++;
        res[i] = labelsCount[labels.charAt(i) - 'a'];
        return labelsCount;
    }
}

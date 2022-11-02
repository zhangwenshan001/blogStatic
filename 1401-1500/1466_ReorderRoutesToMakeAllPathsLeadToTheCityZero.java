class Solution {
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i<n;i++) adj.add(new ArrayList<Integer>());
        for (int[] connection : connections) {
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(-connection[0]);
        }

        boolean[] marked = new boolean[n];
        dfs(adj, marked, 0);
        return count;
    }

    private void dfs(List<List<Integer>> adj, boolean[] marked, int i) {
        if (marked[i]) return;
        marked[i] = true;

        for (int w : adj.get(i)) {
            if (w > 0 && !marked[w]) {
                count++;
                dfs(adj, marked, w);
            } else if (w < 0 && !marked[-w]) {
                dfs(adj, marked, -w);
            }
        }
        return;
    }
}
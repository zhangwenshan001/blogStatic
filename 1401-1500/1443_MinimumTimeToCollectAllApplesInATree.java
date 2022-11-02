class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i<n;i++) adj.add(new ArrayList<Integer>());
        for (int i = 0;i<edges.length;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] marked = new boolean[n];
        return dfs(adj, marked, 0, hasApple);
    }
    
    private int dfs(List<List<Integer>> adj, boolean[] marked, int i, List<Boolean> hasApple) {
        if (marked[i]) return 0;
        marked[i] = true;
        int time = 0;

        for (int k : adj.get(i)) {
            if (!marked[k]) {
                time += dfs(adj, marked, k, hasApple);
            }
        }
        if (i != 0 && (time > 0 || hasApple.get(i))) time+=2;
        return time;
    }
}
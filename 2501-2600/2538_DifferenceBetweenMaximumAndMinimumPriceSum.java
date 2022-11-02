class Solution {
    private long[] maxSub;
    private long ans;
    public long maxOutput(int n, int[][] edges, int[] price) {
        maxSub = new long[n];
        ans = 0;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i<n;i++) adj.add(new ArrayList<Integer>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfsOne(adj, price, 0, -1);
        dfsAll(adj, price, 0, -1, 0);
        return ans;
    }

    private long dfsOne(List<List<Integer>> adj, int[] price, int cur, int parent) {
        long curMax = 0;
        for (int w : adj.get(cur)) {
            if (w == parent) continue;
            curMax = Math.max(curMax, dfsOne(adj, price, w, cur));
        }
        maxSub[cur] = price[cur] + curMax;
        return maxSub[cur];
    }
    
    private void dfsAll(List<List<Integer>> adj, int[] price, int cur, int parent, long preMax) {
        long m1 = 0, m2 = 0;
        int mnode = -1;
        for (int w : adj.get(cur)) {
            if (w == parent) continue;
            if (maxSub[w] > m1) { // w is the max
                m2 = m1;
                m1 = maxSub[w];
                mnode = w;
            } else if (maxSub[w] > m2) {
                m2 = maxSub[w];
            }
        }

        ans = Math.max(ans, Math.max(m1, preMax));
        for (int w : adj.get(cur)) {
            if (w == parent) continue;
            if (w == mnode) dfsAll(adj, price, w, cur, price[cur] + Math.max(preMax, m2));
            else dfsAll(adj, price, w, cur, price[cur] + Math.max(preMax, m1));
        }

    }
}
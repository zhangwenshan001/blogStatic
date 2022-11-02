class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for (int i = 0;i<edges.length;i++) {
            int[] edge = edges[i];
            long prob = (long)(succProb[i] * 1000000l);
            adj.get(edge[0]).add(new long[]{(long)edge[1], prob});
            adj.get(edge[1]).add(new long[]{(long)edge[0], prob});
        }

        long[] dist = new long[n];
        boolean[] marked = new boolean[n];
        dist[start] = 1000000l;
        marked[start] = true;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (int)b[1] - (int)a[1]);
        for (long[] w : adj.get(start)) pq.add(w);

        while(!marked[end] && pq.size() > 0) {
            long[] cur = pq.poll();
            if (marked[(int)cur[0]]) continue;
            marked[(int)cur[0]] = true;
            dist[(int)cur[0]] = cur[1];
            for (long[] w : adj.get((int)cur[0])) {
                if (marked[(int)w[0]])continue;
                pq.add(new long[]{w[0], cur[1] * w[1] / 1000000});
            }

        }

        return (double)dist[end] / 1000000;

    }
}
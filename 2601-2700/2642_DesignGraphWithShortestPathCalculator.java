class Graph {
    List<List<int[]>> adj = new ArrayList<>();  
    public Graph(int n, int[][] edges) {
        for (int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        int n = adj.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[node1] = 0;
        pq.offer(new int[]{node1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (node2 == cur[0]) return cur[1];
            if (cur[1] > dist[cur[0]]) continue;
            for (int[] w : adj.get(cur[0])) {
                if (dist[w[0]] < 0 || dist[w[0]] > cur[1] + w[1]) {
                    dist[w[0]] = cur[1] + w[1];
                    pq.offer(new int[]{w[0], dist[w[0]]});
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
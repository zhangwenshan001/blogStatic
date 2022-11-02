class Solution {
    int n;
    List<int[]>[] adj;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.n = n;
        adj = new List[n];
        for (int i =0;i<n;i++) {
            adj[i] = new LinkedList<>();
        }
        for(int i =0;i<flights.length;i++) {
            int v = flights[i][0];
            int w = flights[i][1];
            int weight = flights[i][2];
            adj[v].add(new int[]{w,weight});
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{src, 0});
        
        int curCount = 1;
        int nextCount = 0;
        int[] nextDist = dist.clone();
        while(k>=0 && !q.isEmpty()) {
            int[] cur = q.poll();
            int v = cur[0];
            int weight = cur[1];
            for(int[] w : adj[v]) {
                if (nextDist[w[0]] > dist[v] + w[1]) {
                    nextDist[w[0]] = dist[v] + w[1];
                    q.offer(new int[]{w[0], nextDist[w[0]]});
                    nextCount++;
                }
            }
            curCount--;
            if (curCount==0) {
                curCount = nextCount;
                nextCount = 0;
                dist = nextDist.clone();
                k--;
            }
        }
        
        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        
        return dist[dst];
    }
}
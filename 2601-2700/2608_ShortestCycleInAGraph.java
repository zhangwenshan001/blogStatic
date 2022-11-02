class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i<n;i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        


        int ans = -1;
        
        for (int i = 0;i<n;i++) {
            int[] dist = new int[n];
            int[] parent = new int[n];
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            dist[i] = 0;   

            while(!q.isEmpty()) {
                int cur = q.poll();
                for (int w : adj.get(cur)) {
                    if (dist[w] < 0) {
                        q.offer(w);
                        parent[w] = cur;
                        dist[w] = dist[cur]+1;
                    } else if (parent[cur] >=0 && parent[cur] != w) {
                        ans = ans < 0 ? dist[cur]+dist[w] + 1 : Math.min(ans, dist[cur]+dist[w]+1);
                    }
                }
            }
        }
        return ans;
    }
}
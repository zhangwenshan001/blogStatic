class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair<Integer, Integer>>> adj = adj(n, flights);
        int[] costs = new int[n];
        Arrays.fill(costs, -1);
        costs[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(k >= 0 && q.size()>0) {
            int[] tmp = costs.clone();
            int size = q.size();
            for (int i =0;i<size;i++) {
                int cur = q.poll();

                for (Pair<Integer, Integer> w : adj.get(cur)) {
                    if (tmp[w.getKey()] < 0 || tmp[w.getKey()] > costs[cur] + w.getValue()) {
                        tmp[w.getKey()] = costs[cur] + w.getValue();
                        q.offer(w.getKey());
                    }
                }
            }
            costs = tmp;
            k--;
        }
        return costs[dst];
    }

    private List<List<Pair<Integer, Integer>>> adj(int n, int[][] flights) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] flight : flights) {
            adj.get(flight[0]).add(new Pair<Integer, Integer>(flight[1], flight[2]));
        }
        return adj;
    }
}
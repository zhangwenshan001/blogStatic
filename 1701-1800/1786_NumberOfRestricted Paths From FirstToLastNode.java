class Solution {
    
    int[] memo;
    public final int mod = (int) 1e9+7;
    
    public int countRestrictedPaths(int n, int[][] edges) {
        // build adjacency list
        List<int[]>[] graph = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        
        // dp table
        int[] sp = new int[n+1];
        Arrays.fill(sp, Integer.MAX_VALUE);
        sp[n] = 0;
        
        // pq -- find global min esp
        Queue<State> pq = new PriorityQueue<>((a,b) -> a.esp - b.esp);
        pq.offer(new State(n, 0));
        
        // start BFS
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int curId = cur.id, curEsp = cur.esp;
            if (curEsp > sp[curId]) continue;
            for (int[] edge : graph[curId]) {
                int nxtId = edge[0], distToNxt = sp[curId] + edge[1];
                if (sp[nxtId] > distToNxt) {
                    sp[nxtId] = distToNxt;
                    pq.offer(new State(nxtId, distToNxt));
                }
            }
        }
        
        // DFS + memo
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dfs(graph, sp, 1, n);
    }
    
    private int dfs(List<int[]>[] graph, int[] sp, int start, int end) {
        if (start == end) return 1;
        if (memo[start] != -1) return memo[start];
        memo[start] = 0;
        for (int[] edge : graph[start]) {
            if (sp[start] > sp[edge[0]]) {
                memo[start] = (memo[start] + dfs(graph, sp, edge[0], end)) % mod;
            }
        }
        return memo[start];
    }
}

class State {
    public int id;
    public int esp;
    
    public State(int id, int esp) {
        this.id = id;
        this.esp = esp;
    }
}

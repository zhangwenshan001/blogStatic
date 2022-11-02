class Solution {
    int ans = 0;
    int cur = 0;
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<bombs.length;i++) adj.add(new ArrayList<>());
        for (int i = 0;i<bombs.length-1;i++) {
            for (int j = i+1;j<bombs.length;j++) {
                int dx = bombs[i][0] - bombs[j][0];
                int dy = bombs[i][1] - bombs[j][1];
                if ((long) dx * dx +  (long)dy * dy <= (long)bombs[i][2] * bombs[i][2]) {
                    adj.get(i).add(j);
                }
                if ((long) dx * dx +  (long)dy * dy <= (long)bombs[j][2] * bombs[j][2]) {
                    adj.get(j).add(i);
                }
            }
        }
        for (int i = 0;i<bombs.length;i++) {
            boolean[] marked = new boolean[bombs.length];
            cur = 0;
            dfs(adj, marked, i);
        }

        return ans;
    }

    private void dfs(List<List<Integer>> adj, boolean[] marked, int i) {
        if (marked[i]) return;
        marked[i] = true;
        cur++;
        ans = Math.max(ans, cur);
        for (int w : adj.get(i)) {
            if (!marked[w]) {
                dfs(adj, marked, w);
            }
        }
    }
}
class Solution {
    public int numSimilarGroups(String[] strs) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i<strs.length;i++) adj.add(new ArrayList<Integer>());
        for (int i = 0;i<strs.length-1;i++) {
            for (int j = i+1;j<strs.length;j++) {
                if (isAdj(strs[i], strs[j])) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] marked = new boolean[strs.length];
        int count = 0;
        for (int i = 0;i<strs.length;i++) {
            if (!marked[i]) {
                count++;
                dfs(adj, marked, i);
            }
        }
        return count;
        
    }

    private void dfs(List<List<Integer>> adj, boolean[] marked, int i) {
        if (marked[i]) return;
        marked[i] = true;

        for (int w : adj.get(i)) {
            if (!marked[w]) {
                dfs(adj, marked, w);
            }
        }

    }

    private boolean isAdj(String s1, String s2) {
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 0;i<s1.length();i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (idx1 < 0) idx1 = i;
                else if (idx2 < 0) idx2 = i;
                else return false;
            }
        }
        if (idx1 >= 0 && idx2 >= 0 && s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1)) return true;
        if (idx1 < 0 && idx2 < 0) return true;
        return false;
    }
}
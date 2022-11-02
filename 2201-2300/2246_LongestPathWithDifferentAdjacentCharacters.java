class Solution {
    int longestPath = 0;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0;i<parent.length;i++) children.add(new ArrayList<>());
        for (int i = 1;i<parent.length;i++) {
            children.get(parent[i]).add(i);
        }

        dfs(children, s, 0);
        return longestPath;
    }

    private int dfs(List<List<Integer>> children, String s, int i) {
        int firstMax = 0;
        int secondMax = 0;
        for (int child : children.get(i)) {
            int childDist = dfs(children, s, child);
            if (s.charAt(i) != s.charAt(child)) {
                if (childDist >= firstMax) {
                    secondMax = firstMax;
                    firstMax = childDist;
                } else if (childDist >= secondMax) {
                    secondMax = childDist;
                }
            }
        }
        longestPath = Math.max(longestPath, firstMax+secondMax+1);
        return firstMax+1;
    }
}
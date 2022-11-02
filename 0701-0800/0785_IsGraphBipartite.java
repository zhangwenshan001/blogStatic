class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> partOne = new HashSet<>();
        Set<Integer> partTwo = new HashSet<>();

        for (int i = 0;i<graph.length;i++) {
            boolean flag = partTwo.contains(i);
            if (!dfs(graph, i, partOne, partTwo, flag)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int i, Set<Integer> partOne, Set<Integer> partTwo, boolean flag) {
        if (partOne.contains(i) && flag || partTwo.contains(i) && !flag) return false;
        if (partOne.contains(i) && !flag || partTwo.contains(i) && flag) return true;

        if (!flag) partOne.add(i);
        else partTwo.add(i); 

        for (int w : graph[i]) {
            if (!dfs(graph, w, partOne, partTwo, !flag)) return false;
        }
        return true;
    }
}
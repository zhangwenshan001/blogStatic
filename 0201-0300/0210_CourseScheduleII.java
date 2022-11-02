class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[numCourses];
        for(int i = 0;i<numCourses;i++) adj.add(new ArrayList<>());
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[0]]++;
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[numCourses];
        int k = 0;
        for (int i = 0;i<numCourses;i++) {
            if (degree[i] == 0) q.add(i);
        }

        while(q.size() > 0) {
            int cur = q.poll();
            ans[k++] = cur;
            for (int w : adj.get(cur)) {
                degree[w]--;
                if (degree[w] == 0) q.add(w);
            }
        }

        return k == numCourses ? ans : new int[0];
    }
}
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i<n;i++) adj.add(new ArrayList<>());
        int[] degree = new int[n];
        
        for (int[] relation : relations) {
            adj.get(relation[0]-1).add(relation[1]-1);
            degree[relation[1]-1]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] minTime = new int[n];
        Arrays.fill(minTime, -1);

        int ans = 0;
        for (int i = 0;i<n;i++) {
            if (degree[i] == 0) {
                q.add(i);
                minTime[i] = time[i];
                ans = Math.max(ans, minTime[i]);
            }
        }

        while(q.size() > 0) {
            int cur = q.poll();
            for (int w : adj.get(cur)) {
                degree[w]--;
                minTime[w] =  minTime[w] < 0 ? minTime[cur] + time[w] : Math.max(minTime[w], minTime[cur] + time[w]);
                if (degree[w] == 0) {
                    ans = Math.max(ans, minTime[w]);
                    q.add(w);
                }
            }
        }  
        return ans;    

    }
}
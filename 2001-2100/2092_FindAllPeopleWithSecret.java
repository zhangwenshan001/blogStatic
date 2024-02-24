class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> ans = new HashSet<>();
        ans.add(0);
        ans.add(firstPerson);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        for (int[] m : meetings) pq.offer(m);
        int curTime = 0;
        Queue<int[]> q = new LinkedList<>();

        while(pq.size() > 0) {
            while(pq.size() > 0 && curTime == pq.peek()[2]) {
                int[] cur = pq.poll();
                if (ans.contains(cur[0]) || ans.contains(cur[1])) {
                    ans.add(cur[0]);
                    ans.add(cur[1]);
                } else {
                    q.offer(cur);
                }
            }
            while(true) {
                int preSize = q.size();
                for (int i = 0;i<preSize;i++) {
                    int[] tmp = q.poll();
                    if (ans.contains(tmp[0]) || ans.contains(tmp[1])) {
                        ans.add(tmp[0]);
                        ans.add(tmp[1]);
                    } else {
                        q.offer(tmp);
                    }
                }
                if (preSize == q.size()) break;
            }

            if (pq.size() > 0) curTime = pq.peek()[2];
            q = new LinkedList<>();
        }

        return new ArrayList<>(ans);
    }
}
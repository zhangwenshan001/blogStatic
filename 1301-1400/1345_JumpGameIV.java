class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> idx = new HashMap<>();
        for (int i = 0; i < n; i++) idx.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);

        boolean[] mark = new boolean[n]; 
        mark[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int count = 0;
        int size = q.size();
        while(size > 0) {
            for (int i = 0;i<size;i++) {
                int cur = q.poll();
                if (cur == n-1) return count;
                List<Integer> li = idx.get(arr[cur]);
                li.add(cur - 1);
                li.add(cur + 1);
                for (int next : li) {
                    if (next >= 0 && next < n && !mark[next]) {
                        q.offer(next);
                        mark[next] = true;
                    }
                }
                li.clear();
            }
            count++;
            size = q.size();
        }
        return -1;
    }
}
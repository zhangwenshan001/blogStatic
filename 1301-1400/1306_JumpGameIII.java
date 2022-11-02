class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] mark = new boolean[n];
        mark[start] = true;
        Queue<Integer> q = new LinkedList<>();
        if (arr[start] == 0) return true;
        q.offer(start);
        while(q.size() > 0) {
            int curIdx = q.poll();
            if (curIdx - arr[curIdx] >= 0 && !mark[curIdx - arr[curIdx]]) {
                if (arr[curIdx - arr[curIdx]] == 0) return true;
                q.offer(curIdx - arr[curIdx]);
                mark[curIdx - arr[curIdx]] = true;
            }
            if (curIdx + arr[curIdx] < n && !mark[curIdx + arr[curIdx]]) {
                if (arr[curIdx + arr[curIdx]] == 0) return true;
                q.offer(curIdx + arr[curIdx]);
                 mark[curIdx + arr[curIdx]] = true;
            }
        }

        return false;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] prjs = new int[profits.length][2];
        for (int i = 0;i<profits.length;i++) {
            prjs[i] = new int[]{profits[i], capital[i]};
        }
        Arrays.sort(prjs, (a, b) -> a[1] - b[1]); // sort by capital;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);//sort by profits desc
        int pIndex = 0;
        int count = 0;
        while (pIndex < profits.length && prjs[pIndex][1] <= w) {
            pq.add(prjs[pIndex++]);
        }
        while (count < k && pq.size() > 0) {
            int[] cur = pq.poll();
            w += cur[0];
            count++;
            while(pIndex < profits.length && prjs[pIndex][1] <= w) {
                pq.add(prjs[pIndex++]);
            }
        }
        return w;
    }
}
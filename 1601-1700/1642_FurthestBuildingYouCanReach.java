class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = 0;
        for (int i = 0;i<heights.length;i++) {
            if (i == heights.length-1) return i;
            if (heights[i+1] - heights[i] > 0) {
                pq.offer(heights[i+1] - heights[i]);
                if (pq.size() > ladders) {
                    total += pq.poll();
                }
                if (total > bricks) return i;
            }
        }
        return 0;
    }
}
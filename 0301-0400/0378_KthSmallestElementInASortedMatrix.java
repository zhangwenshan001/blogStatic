class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Num> pq = new PriorityQueue<Num>((a,b) -> a.val - b.val);
        for (int i = 0;i<matrix.length;i++) {
            pq.offer(new Num(i, 0, matrix[i][0]));
        }
        for (int i = 0;i<k-1;i++) {
            Num cur = pq.poll();
            if (cur.j == matrix[0].length-1) continue;
            pq.offer(new Num(cur.i, cur.j+1, matrix[cur.i][cur.j+1]));
        }
        return pq.poll().val;
    }
}

class Num {
    int i;
    int j;
    int val;
    public Num(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}
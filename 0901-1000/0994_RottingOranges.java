class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int freshCount = 0;

        Queue<Pos> q = new LinkedList<>();
        int ans = 0;
        for (int i = 0;i<m;i++) {
            for (int j = 0; j<n;j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pos(i,j));
                }
                if (grid[i][j] == 1) freshCount++;
            }
        }

        // bfs
        while(q.size() > 0) {
            int size = q.size();
            for(int i = 0;i<size;i++) {
                Pos cur = q.poll();
                if (cur.x > 0 && grid[cur.x-1][cur.y] == 1) {
                    q.offer(new Pos(cur.x-1, cur.y));
                    grid[cur.x-1][cur.y] = 2;
                    freshCount--;
                }
                if (cur.x < m-1 && grid[cur.x+1][cur.y] == 1) {
                    q.offer(new Pos(cur.x+1, cur.y));
                    grid[cur.x+1][cur.y] = 2;
                    freshCount--;
                }
                if (cur.y > 0 && grid[cur.x][cur.y-1] == 1) {
                    q.offer(new Pos(cur.x, cur.y-1));
                    grid[cur.x][cur.y-1] = 2;
                    freshCount--;
                }
                if (cur.y < n-1 && grid[cur.x][cur.y+1] == 1) {
                    q.offer(new Pos(cur.x, cur.y+1));
                    grid[cur.x][cur.y+1] = 2;
                    freshCount--;
                }
            }
            ans++;
        }

        return freshCount == 0 ? Math.max(ans-1, 0) : -1;
    }
}

class Pos {
    int x;
    int y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
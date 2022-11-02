class Solution {
    private int getRow(int i, int n)
    {
        return n - 1 - i / n;
    }

    private int getCol(int i, int n)
    {
        int row = getRow(i, n);
        if (n%2==0 && row%2==1 || n%2==1 && row%2==0) { // ->
            return i - (i / n) * n;
        } 
        return  n - 1 - i + (i/n) * n;
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] res = new int[n*n];
        Arrays.fill(res, -1);
        dfs(board, res, 0, -1, false);
        return res[n*n-1];
    }

    private void dfs(int[][] board, int[] res, int i, int pre, boolean fromLadderOrSnake)
    {
        int n = board.length;
        int row = getRow(i, n);
        int col = getCol(i, n);
        if (fromLadderOrSnake && pre + 1 >= res[i] && res[i] >= 0) return;
        if (!fromLadderOrSnake && board[row][col] >= 0) {
            dfs(board, res, board[row][col]-1, pre, true);
            return;
        }

        if (pre + 1 >= res[i] && res[i] >= 0) return;
        res[i] = pre+1;
        for (int j = i+1;j<=Math.min(i+6, board.length*board.length-1);j++) {
            dfs(board, res, j, pre+1, false);
        }
    }
}
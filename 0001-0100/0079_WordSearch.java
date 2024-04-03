class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] marked = new boolean[board.length][board[0].length];
        for (int i = 0;i<board.length;i++) {
            for (int j = 0;j<board[0].length;j++) {
                if (board[i][j] == word.charAt(0) && existFrom(board, marked, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean existFrom(char[][] board, boolean[][] marked, String word, int idx, int i, int j) {
        if (i<0 || i>=board.length || j < 0 || j >= board[0].length || marked[i][j]) return false;
        if (idx == word.length()-1) {
            return board[i][j] == word.charAt(idx);
        }
        if (word.charAt(idx) != board[i][j]) return false;
        marked[i][j] = true;
        boolean curRes = existFrom(board, marked, word, idx+1, i+1, j) ||
            existFrom(board, marked, word, idx+1, i-1, j) ||
            existFrom(board, marked, word, idx+1, i, j-1) ||
            existFrom(board, marked, word, idx+1, i, j+1);
        marked[i][j] = false;
        return curRes;
    }
}
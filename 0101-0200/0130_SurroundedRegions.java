class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0;i<m;i++) {
            dfs(board, i, 0, m, n);
            if (n > 1) {
                dfs(board, i, n-1, m, n);
            } 
        }
        
        for(int j =0;j<n;j++) {
            dfs(board, 0, j, m, n);  
            if (m > 1) {
               dfs(board, m-1, j, m, n);
            }
        }
        
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }        
            }
        }
        
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
        
        return;
    }
    
    public void dfs(char[][] board, int i, int j, int m, int n)
    {
        if (i < 0 || i>= m || j < 0 || j>= n){
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            dfs(board, i-1, j, m, n);  
            dfs(board, i+1, j, m, n);  
            dfs(board, i, j-1, m, n);  
            dfs(board, i, j+1, m, n);  
        }
    }
}
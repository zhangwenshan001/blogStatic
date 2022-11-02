class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] validator = new int[27][9];
        int num;
        int pos;
        for(int i = 0 ;i<9;i++) {
            for(int j = 0;j<9;j++) {
                if (board[i][j] != '.') {
                    num = (int)(board[i][j] - '0');
                    pos = 3 * (i / 3) + j / 3;
                    if (validator[i][num-1] == 1 || validator[j+9][num-1] == 1 || validator[pos+18][num-1] == 1) {
                        return false;
                    }
                    validator[i][num-1] = 1;
                    validator[j+9][num-1] = 1;
                    validator[pos+18][num-1]=1;
                }
            }
        }

        return true;
    }
}
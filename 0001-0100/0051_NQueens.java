class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> chessboard = new ArrayList<>();
        for (int i = 0;i<n;i++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0;k<n;k++) sb.append('.');
            chessboard.add(sb);
        }
        putNQueen(ans, chessboard, 0, n);
        return ans;
    }

    private void putNQueen(List<List<String>> ans, List<StringBuilder> chessboard, int i, int n) {
        if (i == n) {
            List<String> curAns = new ArrayList<>();
            for (StringBuilder sb : chessboard) {
                curAns.add(sb.toString());
            }
            ans.add(curAns);
            return;
        }

        // put cur queen at some place in i-th row
        for (int j = 0;j<n;j++) {
            boolean canPut = true;
            for (int k = 0;k<i;k++) {
                if (chessboard.get(k).charAt(j) == 'Q') {
                    canPut = false;
                    break;
                }
            }
            if (!canPut) continue;

            int tmpi = i-1;
            int tmpjl = j-1;
            int tmpjr = j+1;
            while(tmpi >= 0) {
                if (tmpjl >= 0) {
                    if (chessboard.get(tmpi).charAt(tmpjl) == 'Q'){
                        canPut = false;
                        break;
                    }
                    tmpjl--;
                }
                if (tmpjr < n) {
                    if (chessboard.get(tmpi).charAt(tmpjr) == 'Q') {
                        canPut = false;
                        break;
                    }
                    tmpjr++;
                }
                tmpi--;
            }
            if (!canPut) continue;
            
            // now we can put cur queen at j-th col
            chessboard.get(i).setCharAt(j, 'Q');
            putNQueen(ans, chessboard, i+1, n);
            chessboard.get(i).setCharAt(j, '.');
        }
    }
}
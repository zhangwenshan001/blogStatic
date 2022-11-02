class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int c = n + m - 1;
        for(int i = 0;i < c;i++) {
            List<Integer> tmp = new ArrayList<>();
            int a, b;
            if (i + 1 <= m) {
                a = 0;
                b = m - 1 - i;
            } else {
                a = i + 1 - m;
                b = 0;
            }
            int a0 = a;
            int b0 = b;
            while (a0 < n && b0 < m) {
                tmp.add(mat[a0++][b0++]);
            }
            Collections.sort(tmp); 
            a0 = a;
            b0 = b;
            int idx = 0;
            while (a0 < n && b0 <m) {
                mat[a0++][b0++] = tmp.get(idx++);
            }
        }
        return mat;
    }
}
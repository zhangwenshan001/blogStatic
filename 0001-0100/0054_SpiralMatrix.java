class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (up <= down && left <= right) {
            //->
            for (int j = left;j<=right;j++) {
                res.add(matrix[up][j]);
            }
            up++; 
            //↓
            for (int i = up;i<=down;i++) { 
                res.add(matrix[i][right]);
            }
            right--; 

            //<-
            if (up <= down) { //only if up <= down do we need to add down-row data
                for(int j = right;j>=left;j--) {
                    res.add(matrix[down][j]);
                }
                down--; 
            }

            //↑
            if (left <= right) { //only if left <= right do we need to add left-col data
                for(int i = down;i>=up;i--) {
                    res.add(matrix[i][left]);
                }
                left++; 
            }


        }
        return res;
    }
}
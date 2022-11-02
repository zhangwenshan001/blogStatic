class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] marked = new int[m][n];
        if (image[sr][sc] == color) return image;
        int sourceColor = image[sr][sc];
        bfs(image, sr, sc, marked, sourceColor, color);
        return image;
    }
    
    public void bfs(int[][] image, int i, int j, int[][] marked, int sourceColor, int targetColor) {
        if (marked[i][j] == 1 || image[i][j] != sourceColor) return;
        marked[i][j] = 1;
        image[i][j] = targetColor;
        if (i > 0) bfs(image, i-1,j,marked, sourceColor, targetColor);
        if (i < image.length - 1) bfs(image, i+1,j,marked, sourceColor, targetColor);
        if (j > 0) bfs(image, i,j-1,marked, sourceColor, targetColor);
        if (j < image[0].length - 1) bfs(image, i,j+1,marked, sourceColor, targetColor);
        return;
    }
}
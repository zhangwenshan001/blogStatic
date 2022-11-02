class Solution {
    long count;
    int[] firstBox;
    public double getProbability(int[] balls) {
        int total = 0;
        for(int i = 0;i<balls.length;i++) {
            total += balls[i];
        }
        firstBox = new int[balls.length];

        count = 0;
        backTracking(balls, 0, total / 2, total / 2, 0, 0);
        long all = (long) total;
        for (int k = 2;k<=total / 2;k++) all = all * (total-k+1) / k;
        
        return (double) count / all;
    }

    private void backTracking(int[] balls, int i, int a, int b, int c1, int c2) {
        if (i == balls.length) {
            if (c1 == c2) {
                long c = 1;
                for (int j = 0;j<balls.length;j++) {
                    if (firstBox[j] == 0) continue;
                    for (int k = 1;k<=firstBox[j];k++) c = c * (balls[j]-k+1) / k;
                }
                count += c;

            }
            return;
        }

        for (int k = Math.min(balls[i], a);k>=Math.max(0, balls[i] - b);k--) {
            firstBox[i] = k; // put k ball to firstBox;
            backTracking(
                balls, 
                i+1, 
                a-k, 
                b-(balls[i] - k),
                k > 0 ? c1+1 : c1,
                k < balls[i] ? c2+1 : c2
            );
        }
        return;
    }
}
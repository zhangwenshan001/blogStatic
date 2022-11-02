class Solution {
    private int minMax = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] distribution = new int[k];
        dfs(cookies, distribution, k, 0);
        return minMax;
    }

    private void dfs(int[] cookies, int[] distribution, int k, int i) {
        int cookie = cookies[i]; // current cookie num

        // if last one
        if (i == cookies.length-1) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int num : distribution) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            max = Math.max(max, min + cookie);
            minMax = Math.min(minMax, max);
            return;
        }
        
        for (int j = 0;j<k;j++) {
            distribution[j] += cookie;
            dfs(cookies, distribution, k, i+1);
            distribution[j] -= cookie;
        }
    }
}
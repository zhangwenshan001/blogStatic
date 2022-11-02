class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0;i<=n;i++) {
            if (i == 0) {
                ans[i] = 0;
                continue;
            }
            int tmp = 1;
            while(tmp < i) tmp *= 2;
            if (tmp == i) {
                ans[i] = 1;
                continue;
            }
            ans[i] = ans[i - tmp/2] + 1;
        }
        return ans;
    }
}
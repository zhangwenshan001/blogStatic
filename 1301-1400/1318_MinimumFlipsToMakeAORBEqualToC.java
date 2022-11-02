class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while(c > 0 || a > 0 || b > 0) {
            int cbit = c & 1;
            int abit = a & 1;
            int bbit = b & 1;
            if (cbit == 0) {
                ans += (abit == 1) ? 1 : 0;
                ans += (bbit == 1) ? 1 : 0;
            } else {
                if (abit == 0 && bbit == 0) ans += 1;
            }

            c = c >> 1;
            a = a >> 1;
            b = b >> 1;
        }

        return ans;
    }
}
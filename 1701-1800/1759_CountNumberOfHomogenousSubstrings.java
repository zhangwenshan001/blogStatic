class Solution {
    public int countHomogenous(String s) {
        long ans = 0;
        int i = 0;
        while(i < s.length()) {
            int curLen = 1;
            i++;
            while(i < s.length() && s.charAt(i) == s.charAt(i-1)) {
                curLen++;
                i++;
            }
            ans = ((long)(curLen + 1) * curLen / 2 + ans) % 1000000007;
        }

        return (int)ans;
    }
}
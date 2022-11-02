class Solution {
    public int minFlipsMonoIncr(String s) {
        int slen = s.length();
        int[] zeroCount = new int[slen];
        zeroCount[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1;i<slen;i++) {
            zeroCount[i] = s.charAt(i) == '0' ? zeroCount[i-1] + 1 : zeroCount[i-1];
        }

        int min = zeroCount[slen-1]; // slip all 0s to 1s
        for (int i = 0;i<slen;i++) {
            // flip [0, i] to 0s and [i+1, slen) to 1s
            int cur = i+1-zeroCount[i] + zeroCount[slen-1]-zeroCount[i]; // count of 1 between [0, i] + count of 0 beween [i+1, slen)
            min = Math.min(min, cur);
        }
        return min;
    }
}
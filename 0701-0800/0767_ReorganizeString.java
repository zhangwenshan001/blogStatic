class Solution {
    public String reorganizeString(String s) {
        int[] charCounts = new int[26];
        int maxIdx = -1;
        for (int i = 0;i<s.length();i++) {
            charCounts[s.charAt(i) - 'a']++;
        }
        for (int i =0;i<26;i++) {
            if (maxIdx < 0 || charCounts[i] > charCounts[maxIdx]) maxIdx = i;
        }
        if (charCounts[maxIdx] > s.length() - charCounts[maxIdx] + 1) return new String();

        char[] res = new char[s.length()];
        int idx = 0;
        while (charCounts[maxIdx] > 0) {
            res[idx] = (char) (maxIdx + 'a');
            idx += 2;
            charCounts[maxIdx]--;
        }
        for (int i = 0; i < 26; i++) {
            while (charCounts[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                charCounts[i]--;
            }
        }
        return String.valueOf(res);

    }
}
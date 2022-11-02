class Solution {
    public char findTheDifference(String s, String t) {
        int[] chs = new int[26];
        for(char c : s.toCharArray()) {
            chs[c-'a']++;
        }
        for(char c : t.toCharArray()) {
            if (--chs[c-'a'] < 0) return c;
        }

        return 'a';
    }
}
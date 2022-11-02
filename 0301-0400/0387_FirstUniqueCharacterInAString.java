class Solution {
    public int firstUniqChar(String s) {
        int[] chs = new int[26];
        for (int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            if (chs[c - 'a'] > 0) {
                chs[c - 'a'] = -1;
            } else if (chs[c - 'a'] == 0) {
                chs[c - 'a'] = i+1;
            }
        }
        
        int min = -1;
        for (int i =0;i<26;i++) {
            if (chs[i] > 0 && (min == -1 || chs[i]-1 < min)) {
                min = chs[i]-1;
            }
        }
        return min;
    }
}
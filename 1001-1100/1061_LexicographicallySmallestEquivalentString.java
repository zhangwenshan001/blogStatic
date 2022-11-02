class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] chs = new int[26];
        for (int i =0;i<26;i++) chs[i] = i;
        union(chs, s1, s2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<baseStr.length();i++) {
            sb.append((char)(chs[baseStr.charAt(i) - 'a'] + 'a'));
        }
        return sb.toString();
    }

    private void union(int[] chs, String s1, String s2) {
        for (int i = 0;i<s1.length();i++) {
            int p1 = chs[s1.charAt(i) - 'a'];
            int p2 = chs[s2.charAt(i) - 'a'];
            int max = Math.max(p1, p2);
            int min = Math.min(p1, p2);
            for (int j = 0;j<26;j++) {
                if (chs[j] == max) chs[j] = min; 
            }
        }
    }
}
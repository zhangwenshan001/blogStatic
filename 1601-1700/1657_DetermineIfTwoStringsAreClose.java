class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Set<Character> s = new HashSet<>(); 
        int[] ct1 = new int[26];
        int[] ct2 = new int[26];
        for (int i = 0;i<word1.length();i++) {
            s.add(word1.charAt(i));
            ct1[word1.charAt(i) - 'a']++;
        }

        for (int i = 0;i<word2.length();i++) {
            if (!s.contains(word2.charAt(i))) return false;           
            ct2[word2.charAt(i) - 'a']++;
        }

        Arrays.sort(ct1);
        Arrays.sort(ct2);
        for (int i = 0;i<26;i++) {
            if (ct1[i]!=ct2[i]) return false;
        }
        return true;
    }
}
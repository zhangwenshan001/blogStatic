class Solution {
    public int characterReplacement(String s, int k) {
        int[] m = new int[26];
        int i = 0;
        int j = 0;
        int total = 0;
        int maxCount = 0; // diff = total - maxCount
        int longest = 0;
        while(j<s.length()) {
            if (total - maxCount <= k) {
                m[s.charAt(j) - 'A']++;
                total++;
                if (m[s.charAt(j) - 'A'] > maxCount) {
                    maxCount = m[s.charAt(j) - 'A'];
                }
                if (total - maxCount <= k && j-i+1 >longest){
                    longest = j-i+1;
                }
                j++;
            } else {
                m[s.charAt(i) - 'A']--;
                total--;
                maxCount = 0;
                for(int ci = 0;ci<26;ci++) {
                    if (m[ci] > maxCount) maxCount = m[ci];
                }
                i++;
            }

            
        }

        return longest;
    }
}
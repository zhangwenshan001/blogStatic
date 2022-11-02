class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[26];
        for (char c : p.toCharArray()) cnt[c - 'a']++;
        
        List<Integer> ans = new ArrayList<>();
        for (int r = 0, l = 0; r < s.length(); ++r) {
            char c = s.charAt(r);
            cnt[c - 'a']--;
            while (cnt[c - 'a'] < 0) { // If number of characters `c` is more than our expectation
                cnt[s.charAt(l) - 'a']++;  // Slide left until cnt[c] == 0
                l++;
            }

            if (r - l + 1 == p.length()) { // If we already filled enough `p.length()` chars
                ans.add(l); // Add left index `l` to our result
            }
        }
        return ans;
        

    }
}
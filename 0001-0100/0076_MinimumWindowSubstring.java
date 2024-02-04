class Solution {
    public String minWindow(String s, String t) {
        String ans = new String();
        int total = t.length();
        Map<Character, Integer> counts = getCharCounts(t);
        int i = 0;
        int j = 0;
        while(j < s.length()) {
            while(total > 0 && j < s.length()) {
                char chj = s.charAt(j);
                if (counts.containsKey(chj)) {
                    if (counts.get(chj) > 0) total--;
                    counts.put(chj, counts.get(chj)-1);
                }
                j++;
            }
            while(i < j && counts.getOrDefault(s.charAt(i), -1) < 0) {
                if (counts.containsKey(s.charAt(i))) counts.put(s.charAt(i), counts.get(s.charAt(i))+1);
                i++;
            }
            if (total == 0) ans = (ans.length() == 0 || j - i < ans.length()) ? s.substring(i, j) : ans;
            if (i < j && counts.containsKey(s.charAt(i))) {
                total++;
                counts.put(s.charAt(i), counts.get(s.charAt(i)) + 1);
                i++;
            }
        }
        return ans;
    }

    private Map<Character, Integer> getCharCounts(String t) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0;i<t.length();i++) counts.put(t.charAt(i), counts.getOrDefault(t.charAt(i), 0) + 1);
        return counts;
    }
}
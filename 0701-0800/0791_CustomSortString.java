class Solution {
    public String customSortString(String order, String s) {
        Set<Character> chOrder = new HashSet<>();
        for (char c : order.toCharArray()) chOrder.add(c);

        int[] chCounts = new int[26];
        for (int i = 0;i<s.length();i++) {
            chCounts[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<order.length();i++) {
            for (int j = 0;j<chCounts[order.charAt(i) - 'a'];j++) sb.append(order.charAt(i));
        }

        for (int i = 0;i<26;i++) {
            if (!chOrder.contains((char) (i+'a'))) {
                for (int j = 0;j<chCounts[i];j++) sb.append((char) (i+'a'));
            }
        }
        return sb.toString();
    }
}
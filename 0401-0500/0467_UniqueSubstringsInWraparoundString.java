public class Solution {
    public int findSubstringInWraproundString(String p) {
        // array saves the length of the longest substring that ends with current char
        int[] count = new int[26];

        int maxLength = 0;
        for (int i =0;i<p.length();i++) {
            if (i > 0 && (p.charAt(i) - 1  == p.charAt(i-1) || p.charAt(i) == 'a' &&p.charAt(i-1) == 'z')) {
                maxLength++;
            } else {
                maxLength = 1;
            }
            count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], maxLength);
        }

        int res = 0;
        for(int c : count) res += c;
        return res;
    }
}
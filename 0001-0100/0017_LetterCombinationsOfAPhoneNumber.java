class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        backTracking(digits, 0);
        return ans;
    }
    
    private void backTracking(String digits, int i) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        for (char c : getCharArr(digits.charAt(i) - '0')) {
            sb.append(c);
            backTracking(digits, i+1);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    private char[] getCharArr(int n) {
        char[][] chs =  new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
        };
        return chs[n-2];
    }
}
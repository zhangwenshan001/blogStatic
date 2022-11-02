class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        split(s, 0, res, ans);
        return res; 
    }

    private void split(String s, int i, List<List<String>> res, List<String> ans)
    {
        if (i >= s.length()) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i;j<s.length();j++) {
            if (isPalindrome(s, i, j)) {
                ans.add(s.substring(i, j+1));
                split(s, j+1, res, ans);
                ans.remove(ans.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j)
    {
        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
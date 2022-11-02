class Solution {
    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) return true;
        boolean sHasOne = false;
        boolean tHasOne = false;
        for (int i = 0;i<s.length();i++) {
            if (s.charAt(i) =='1') sHasOne = true;
            if (target.charAt(i) == '1') tHasOne = true;
            if (sHasOne && tHasOne) return true;
        }
        return false;
    }
}
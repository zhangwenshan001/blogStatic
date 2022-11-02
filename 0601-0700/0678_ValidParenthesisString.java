class Solution {
    char[] chs;
    int[][] cache;
    public boolean checkValidString(String s) {
        chs = s.toCharArray();
        cache = new int[s.length()][s.length()];
        return checkValidFrom(0, 0);
    }

    public boolean checkValidFrom(int i, int preLeftCount)
    {
        if (i >= chs.length) {
            return preLeftCount == 0;
        }
        if (cache[i][preLeftCount] != 0) return cache[i][preLeftCount] == 1;

        if (chs[i] == '(') {
            cache[i][preLeftCount] = checkValidFrom(i+1, preLeftCount+1) ? 1 : -1;
        } else if (chs[i] == ')') {
            if (preLeftCount <= 0) return false;
            cache[i][preLeftCount] = checkValidFrom(i+1, preLeftCount-1)? 1 : -1;
        } else {
            cache[i][preLeftCount] = (checkValidFrom(i+1, preLeftCount+1) || preLeftCount > 0 && checkValidFrom(i+1, preLeftCount-1) ||checkValidFrom(i+1, preLeftCount)) ? 1 : -1;
        }
        
        return cache[i][preLeftCount] == 1;
    }
}
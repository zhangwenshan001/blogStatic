class Solution {
    StringBuilder sb;
    List<String> res;
    boolean preZero;
    int curNum;
    int dotNum;
    public List<String> restoreIpAddresses(String s) {
        sb = new StringBuilder();
        res = new ArrayList<>();
        preZero = false;
        curNum = 0;
        dotNum = 0;
        backTracking(s, 0);
        return res;
    }

    public void backTracking(String s, int i)
    {
        if (i >= s.length()) {
            if (dotNum == 3) res.add(sb.toString());
            return;
        }
        // set current digit in curNum;
        int digit = s.charAt(i) - '0';
        int tmp = curNum;
        if (!preZero && curNum * 10 + digit <= 255) {
            curNum = curNum * 10 + digit;
            sb.append(s.charAt(i));
            preZero = (i == 0 && digit == 0);
            backTracking(s, i+1);
            curNum = tmp;
            sb.deleteCharAt(sb.length() - 1);
        } 
        
        if (dotNum >= 3 || i == 0) return;
        sb.append('.');
        sb.append(s.charAt(i));
        dotNum++;
        curNum = digit;
        preZero = (digit == 0);
        backTracking(s, i+1);
        curNum = tmp;
        dotNum--;
        preZero = false;
        sb.setLength(sb.length() - 2);
    }
}
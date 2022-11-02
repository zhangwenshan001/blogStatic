class Solution {
    public String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();

        int i = alen-1;
        int j = blen-1;
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        while(i >= 0 || j >=0) {
            int res;
            if (i >=0 && j>=0) {
                res = flag + a.charAt(i) - '0' + b.charAt(j) - '0';
                i--;
                j--;
            } else if (i >= 0) {
                res = flag + a.charAt(i) - '0';
                i--;
            } else {
                res = flag + b.charAt(j) - '0';
                j--;
            }
            if (res >= 2) flag = 1;
            else flag = 0;
            if (res == 1 || res == 3) sb.append('1');
            else sb.append('0');
        }
        if (flag == 1) sb.append('1');
        return sb.reverse().toString();
    }
}
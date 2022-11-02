class Solution {
    public boolean isNumber(String s) {
        // status
        // 0 - init
        // 1 -> +/-
        // 2 -> (+/-) num
        // 3 -> (+/-) .
        // 4 -> (+/-) num .
        // 5 -> (+/-) . num
        // 6 -> (+/-) num . num
        // 7 -> {4}e  or  {5}e  or {6}e
        // 8 -> {7}(+/-)
        // 9 -> {8}num
        int status = 0; 
        for (int i = 0;i<s.length();i++) {
            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (status == 0) status = 1;
                else if (status == 7) status = 8;
                else return false;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (status == 0 || status == 1 || status == 2) status = 2;
                else if (status == 3 || status == 5) status = 5;
                else if (status == 4 || status == 6) status = 6;
                else if (status >= 7) status = 9;
            } else if (s.charAt(i) == '.') {
                if (status == 0 || status == 1) status = 3;
                else if (status == 2) status = 4;
                else return false;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (status == 2 || status == 4 || status == 5 || status == 6) status = 7;
                else return false;
            } else {
                return false;
            }
        }
        return status == 2 || status == 4 || status == 5 || status == 6 || status == 9;
    }

    


}
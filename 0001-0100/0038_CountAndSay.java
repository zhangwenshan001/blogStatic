class Solution {
    public String countAndSay(int n) {
        //String[] dp = new String[n];
        String pre = "1";
        String cur = "1";
        for(int i = 1;i<n;i++) {
            cur = "";
            int slen = pre.length();
            int count = 1;
            char c = pre.charAt(0);
            for(int j=1;j<slen;j++){
                if (pre.charAt(j) == c) {
                    count++;
                } else {
                    cur = cur + count + c;
                    count = 1;
                    c = pre.charAt(j);
                }
            }
            cur = cur + count + c;
            pre = cur;
        }
        
        return cur;
    }
}
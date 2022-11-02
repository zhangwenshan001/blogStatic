class Solution {
    public String smallestNumber(String pattern) {
        char[] chs = new char[pattern.length()+1];
        int dStartPos = -1;
        int dEndPos = -1;
        char c = '1';
        int i = 0;

        while(i<pattern.length()) {
            // find next I
            while(i<pattern.length() && pattern.charAt(i) != 'I') {
                i++;
            }

            dEndPos = i-1; // last D

            // now char at i is I
            chs[i++] = c++;
            
            while(dEndPos >= Math.max(dStartPos, 0)) {
                chs[dEndPos--] = c++;
            }

            while(i<pattern.length() && pattern.charAt(i) == 'I') {
                chs[i++] = c++;
            }
            
            dStartPos = i;
            if (i == pattern.length() && pattern.charAt(i-1) == 'I') {
                chs[i] = c;
            }
        }

        return new String(chs);
    }
}



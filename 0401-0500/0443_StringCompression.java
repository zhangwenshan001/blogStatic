class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int i = 0;
        char cur = chars[i];
        int count = 0;
        for (int j = 0;j<=chars.length;j++) {
            if (j < chars.length && chars[j] == cur) count++;
            else {
                chars[i++] = cur;
                if (count > 1) {
                    for(char c : Integer.toString(count).toCharArray()) chars[i++] = c;
                }
                if (j < chars.length) {
                    count = 1;
                    cur = chars[j];
                }
            }
        }
        return i;
    }
}
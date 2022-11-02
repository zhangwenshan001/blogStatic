class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] map = new String[26];
        Map<String, Character> m = new HashMap<String, Character>();
        int curStart = 0;
        int curEnd = 0;
        for(int i =0;i<pattern.length();i++) {
            if (curStart >= s.length()) return false;
            curEnd = curStart;
            while(curEnd < s.length() && s.charAt(curEnd) != ' ') {
                curEnd++;
            }
            String sub = s.substring(curStart, curEnd);

            if (map[pattern.charAt(i) - 'a'] != null) {
                if (!map[pattern.charAt(i) - 'a'].equals(sub)) return false;
            } else if (m.containsKey(sub)){
                if (m.get(sub) != pattern.charAt(i)) return false;
            } else {
                map[pattern.charAt(i) - 'a'] = sub;
                m.put(sub,pattern.charAt(i));
            }
            curStart = curEnd+1;
        }
        return curEnd == s.length();

    }
}
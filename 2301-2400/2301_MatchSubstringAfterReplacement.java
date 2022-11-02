
class Solution {
    String s;
    String sub;
    Map<Character, HashSet<Character>> changeTo;
    int[][] dp;
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        this.s = s;
        this.sub = sub;
        dp = new int[s.length()][sub.length()];
        changeTo = new HashMap<Character, HashSet<Character>>();
        for(char[] mapping : mappings) {
            char before = mapping[0];
            char after = mapping[1];
            if (changeTo.containsKey(before)) {
                changeTo.get(before).add(after);
            } else {
                HashSet<Character> st = new HashSet<>();
                st.add(after);
                changeTo.put(before, st);
            }
        }
        return match(0, 0) == 1;
    }

    private int match(int i, int j) {
        if (i >= s.length() || j >= sub.length()) return -1;
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        char before = sub.charAt(j);
        char after =  s.charAt(i);
        // if before matches after
        if (before == after || (changeTo.containsKey(before) && changeTo.get(before).contains(after))) {
            if (j == sub.length()-1) {
                dp[i][j] = 1;
                return 1;
            }
            dp[i][j] = (match(i+1, j+1)==1 || match(i+1, 0)==1) ? 1: -1;
            return dp[i][j];
        } 

        dp[i][j] = match(i+1, 0);
        return dp[i][j];
    }
}

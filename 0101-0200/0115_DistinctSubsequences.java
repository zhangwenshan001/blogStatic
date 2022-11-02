class Solution {
    private int[][] tmp = null;
    
    public int numDistinct(String s, String t) {
        tmp = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++) {
            for(int j =0;j<t.length()-1;j++) {
                tmp[i][j] = -1;
            }
        }
        
        int n = 0;
        for(int i = s.length()-1;i>=0;i--) {
            if (s.charAt(i) == t.charAt(t.length()-1)) {
                n++;
            }
            tmp[i][t.length()-1] = n;
        }
        
        return numDistinctHandle(s,t,0,0);        
    }
    
    public int numDistinctHandle(String s, String t,int i, int j){
        if (i>=s.length() || j>= t.length()) {
            return 0;
        }
        if (s.length()-i < t.length()-j) {
            return 0;
        }
        
        if (tmp[i][j] >= 0) {
            return tmp[i][j];
        }
        
        if (s.charAt(i) != t.charAt(j)) {
            tmp[i][j] = numDistinctHandle(s,t,i+1,j);
        } else {
            int a = numDistinctHandle(s,t,i+1,j);
            int b = numDistinctHandle(s,t,i+1,j+1);
            tmp[i][j] = a + b;
        }
        return tmp[i][j];
    }
}
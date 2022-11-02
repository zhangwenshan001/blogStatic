class Solution {
    public boolean isMatch(String s, String p) {
        if ((s == null && p == null) || (s.length() ==0 && p.length() == 0)) {
			return true;
		}
		if (s.length() > 0 && p.length() == 0)   {
			return false;
		}

		//if p has only '*' mark
		boolean allStartMatch = true;
		for(int pj=0;pj<p.length();pj++) {
			if (p.charAt(pj) != '*') {
				allStartMatch = false;
				break;
			}
		}

		if (allStartMatch) {
			return true;
		}
        
        if (s.length() == 0) {
			return false;
		}
        
		int sLen = s.length();
		int pLen = p.length();
		boolean[][] tmp = new boolean[sLen][pLen];

		tmp[0][0] = (s.charAt(0) == p.charAt(0) || p.charAt(0) == '*' || p.charAt(0) == '?') ;
		for(int i =1;i<sLen;i++) {
			tmp[i][0] = (p.charAt(0) == '*');
		}
		
        boolean preAllStar =  (p.charAt(0) == '*');
		for(int j =1;j<pLen;j++) {
			tmp[0][j] = (preAllStar && (p.charAt(j) == s.charAt(0) || p.charAt(j)  == '?')) || (tmp[0][j-1] && (p.charAt(j) == '*')) ;
			if (preAllStar) {
				if (p.charAt(j) != '*') {
					preAllStar = false;
				}
			}
		}
        
		for(int i =1;i<sLen;i++) {
			for(int j = 1;j<pLen;j++) {
				tmp[i][j] = (tmp[i][j-1] && p.charAt(j) ==  '*') || (tmp[i-1][j] && p.charAt(j) ==  '*') ||
						(tmp[i-1][j-1] && (p.charAt(j) == '?' || p.charAt(j) == '*' || p.charAt(j) == s.charAt(i))) ;
			}
		}

		return tmp[sLen-1][pLen-1];
    }
}
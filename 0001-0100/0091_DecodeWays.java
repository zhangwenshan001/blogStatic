class Solution {
    public int numDecodings(String s) {
        if (s==null || s.length() == 0) {
			 return 0;
		 }

		 if (s.charAt(0) == '0') {
			 return 0;
		 }

		 int ppre = 1;
		 int pre = 1;

		 int cur = pre;
		 for(int i =1;i<s.length();i++) {
			 if (s.charAt(i) == '0') {
				 if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' ) {
					 cur = ppre;
				} else {
					return 0;
				}
			 } else {
				 if (s.charAt(i-1) == '1' ||(s.charAt(i-1) =='2' && (s.charAt(i) - '0') <= 6)) {
					 cur = cur  + ppre;
				 }
			}

			 ppre = pre;
			 pre = cur;
		 }

		 return cur;
    }
}
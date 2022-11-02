class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] tmp = new int[s1.length()][s2.length()];

		 return isInterleaveHandle(s1, 0, s2, 0, s3, tmp);
    }
    
    public boolean isInterleaveHandle(String s1,int i, String s2, int j, String s3, int[][] map) {
		 if (i >= s1.length()) {
			 System.out.println(i + " " + j);
			 return (s2.substring(j).equals(s3.substring(i+j)));
		 }
		 if (j >= s2.length()) {
			 return (s1.substring(i).equals(s3.substring(i+j)));
		 }
		 if (map[i][j] > 0) {
			 return (map[i][j] == 1);
		 }
		 if (i + j >= s3.length()) {
			 map[i][j] = 2;
			 return false;
		 }
		 Character c1 = s1.charAt(i);
		 Character c2 = s2.charAt(j);
		 Character c3 = s3.charAt(i+j);

		 if (c3 != c1 && c3 != c2) {
			 map[i][j] = 2;
			 return false;
		 }

		 boolean res;
		 if (c3 == c1 && c3 != c2) {
			res = isInterleaveHandle(s1, i+1, s2,j, s3, map);
			 map[i][j] = res ? 1 : 2;
			 return res;
		 }
		 if (c3 == c2 && c3 != c1) {
			 res = isInterleaveHandle(s1,i,s2,j+1,s3, map);
			 map[i][j] = res ? 1 : 2;
			 return res;
		 }

		 res = isInterleaveHandle(s1, i+1, s2, j, s3, map) || isInterleaveHandle(s1, i, s2, j+1, s3, map);
		 map[i][j] = res ? 1 : 2;
		 return  res;
	}
}
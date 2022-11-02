class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
		int[] tmp = new int[len];

		for(int i = 0;i<len;i++) {
			for(int j = 0;j<len-i;j++) {
				if (i==0) {
					tmp[j] =  (triangle.get(len-i-1).get(j));
				} else {
					tmp[j] = triangle.get(len-i-1).get(j) + Math.min(tmp[j], tmp[j+1]);
				}
			}
		}

		return tmp[0];
    }
}
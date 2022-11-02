class Solution {
    public int numSquares(int n) {
         int m = (int) Math.sqrt(n);
		  int[] squareNums = new int[m];
		  for(int i = 1;i<=m;i++) {
			  squareNums[i-1] = i * i;
		  }

		  int[] tmp = new int[n];
		  tmp[0] = 1;

		  for(int i = 2;i<=n;i++) {
			  int curMin =Integer.MAX_VALUE;
			  int k = (int) Math.sqrt(i);
			  for(int j =1;j<=k;j++) {
				  if (j*j == i) {
					  curMin = 1;
				  } else {
					  curMin = Math.min(1 + tmp[i-j*j-1], curMin);
				}
			  }
			  tmp[i-1] = curMin;
		  }

		  return tmp[n-1];
    }
}
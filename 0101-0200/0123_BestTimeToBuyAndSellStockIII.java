class Solution {
    public int maxProfit(int[] prices) {
        
         if (prices==null || prices.length == 0) {
			 return 0;
		 }
		 int day = prices.length;
		 int[] preS0 = new int[day];
		 int[] curS0 = new int[day];
		 int[] preS1 = new int[day];
		 int[] curS1 = new int[day];

		 for(int i = 0;i<day;i++) {
			 preS0[i] = 0;
			 curS1[i] = (i == 0) ? -prices[0] : Math.max(curS1[i-1], -prices[i]);
		 }

		 for(int i = 1;i<=2;i++) {
			 for(int j = 0;j<day;j++) {
				 if (i>1) {
					 curS1[j] = (j < 2*i-2) ? Integer.MIN_VALUE : Math.max(curS1[j-1], preS0[j-1] - prices[j]);

				 }
				 curS0[j] =  (j < 2*i-1 || j==0) ? preS0[j] : Math.max(Math.max(curS0[j-1], curS1[j-1]+prices[j]), preS0[j]);

			 }
			 for (int j = 0;j<day;j++) {
				 preS0[j] = curS0[j];
				 preS1[j] = curS1[j];
			 }


		 }

		 return curS0[day-1];
    }
}
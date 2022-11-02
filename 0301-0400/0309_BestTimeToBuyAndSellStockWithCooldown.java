class Solution {
    public int maxProfit(int[] prices) {
       if (prices.length == 0) {
			return 0;
		}
		int day = prices.length;
		int[] s0 = new int[day];
		int[] s1 = new int[day];
		int[] s2 = new int[day];

		s0[0] = 0;
		s1[0] = -prices[0];
		s2[0] = -11;

		for(int i =1;i<day;i++) {
				s0[i] = Math.max(s0[i-1], s2[i-1]);
				s1[i] = Math.max(s0[i-1] - prices[i], s1[i-1]);
				s2[i] = s1[i-1] + prices[i];
		}

		return Math.max(s2[day-1], s0[day-1]);
    }
}
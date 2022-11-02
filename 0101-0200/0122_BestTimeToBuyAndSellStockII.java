class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;

		int curMin = -1;
		for(int i =0;i<prices.length-1;i++) {
			if (curMin == -1 && prices[i+1] > prices[i]) {
				curMin = prices[i]; //buy
				continue;
			}
			if (curMin != -1 && prices[i+1] < prices[i]) {
				sum = sum + prices[i] - curMin;
				curMin = -1; // sell
			}
		}

        if (curMin != -1) {
			sum = sum + prices[prices.length-1] - curMin;
		}
		return sum;
    }
}
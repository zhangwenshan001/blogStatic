class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T.length == 1) {
			return new int[] {0};
		}
		int[] result = new int[T.length];
		result[T.length-1] = 0;
		for(int i = T.length-2;i>=0;i--) {
			if (T[i] < T[i+1]) {
				result[i] = 1;
			} else {
				int tmpDay =i + 1 + result[i+1];

				while(tmpDay < T.length) {
					if (T[tmpDay] > T[i]) {
						result[i] = tmpDay - i;
						break;
					} else if (result[tmpDay] == 0) {
						result[i] = 0;

						break;

					} else {
						tmpDay = tmpDay  + result[tmpDay];
					}

				}

			}
		}
		return result;
    }
}
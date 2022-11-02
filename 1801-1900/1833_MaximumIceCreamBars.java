class Solution {
    int[][] memo;
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for (int cost : costs) {
            max = Math.max(max, cost);
        }
        int[] counts = new int[max+1];

        for (int cost : costs) {
            counts[cost]++;
        }

        int res = 0;
        for (int i=1;i<=max;i++) {
            if (coins < i) return res;

            if (coins - i * counts[i] >= 0) {
                res += counts[i];
                coins -= i * counts[i];
            } else {
                res += coins / i;
                coins = coins % i;
            }
        }
        return res;
    }
}

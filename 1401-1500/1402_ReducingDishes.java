class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int cur = 0;
        int sum = 0;
        int count = 1;
        for (int i = 0;i<satisfaction.length;i++) {
            sum += satisfaction[i];
            cur += satisfaction[i] * count++;
        }

        int res = cur;
        int minusSum = 0;
        for (int i = 0;i<satisfaction.length;i++) {
            cur = cur - sum + minusSum;
            res = Math.max(res, cur);
            minusSum += satisfaction[i];
        }

        return res;
    }
}
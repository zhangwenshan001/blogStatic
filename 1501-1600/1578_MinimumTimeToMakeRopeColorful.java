class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i = 0;
        int j = 0;
        int ans = 0;

        while(j < colors.length()) {
            int curMax = 0;
            int curSum = 0;
            while(j < colors.length() && colors.charAt(j) == colors.charAt(i)) {
                curSum += neededTime[j];
                curMax = Math.max(neededTime[j], curMax);
                j++;
            }

            ans += curSum - curMax;
            i = j;
        }
        return ans;
    }
}
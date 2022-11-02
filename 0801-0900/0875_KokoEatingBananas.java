class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = 0;
            for (int pile : piles) {
                time += (pile - 1) / mid + 1;
            }
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
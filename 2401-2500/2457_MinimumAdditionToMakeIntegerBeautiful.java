

class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long k = n;
        int i = 0;
        while(k > 0) {
            i++;
            k = k/10;
        }
        int[] digits = new int[i];
        k = n;
        for (int j = i-1;j>=0;j--) {
            digits[j] = (int)(k % 10);
            k = k / 10;
        }

        int curSum = 0; 
        int j = 0;
        for (;j<i;j++) {
            curSum += digits[j];
            if (curSum > target) {
                break;
            }
        }
        //now sum of 0~j > target

        //if sum of all <= target
        if (j == i && curSum <= target) return 0;

        while(curSum >= target && j>=0) {
            curSum -= digits[j--];
        }
        //now sum of 0~j <= target
        return (n / (long)Math.pow(10, i-j-1)  + 1) * (long)Math.pow(10, i-j-1) - n;
    }
}

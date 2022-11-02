class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = 0;
        int headMax = 0;
        int tailMax = 0;
        int tailSum = 0;

        int MaxSubArrSum = 0;
        int curMax = 0;
        for (int i = 0;i<arr.length;i++) {
            sum = (sum + arr[i]) % 1000000007;
            tailSum = (tailSum + arr[arr.length-1-i]) % 1000000007;
            headMax = Math.max(headMax, sum);
            tailMax = Math.max(tailMax, tailSum);
            if (curMax + arr[i] >= 0) {
                curMax = (curMax + arr[i]) % 1000000007;
                MaxSubArrSum = Math.max(MaxSubArrSum, curMax);
            } else {
                curMax = 0;
            }
        } 
        if (k >= 2) {
            int curSum = 0;
            int headTail = (headMax + tailMax) % 1000000007;
            for (int i = 0;i< k-2;i++) {
                curSum = (curSum + sum) % 1000000007;
            }
            if (MaxSubArrSum == sum) return curSum + headTail;
            return Math.max(Math.max(MaxSubArrSum, (curSum + headTail)), headTail);
        }
        return MaxSubArrSum;
    }
}
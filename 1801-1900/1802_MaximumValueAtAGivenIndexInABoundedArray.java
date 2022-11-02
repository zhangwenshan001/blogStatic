class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int start = 1;
        int end = maxSum;

        while(start < end-1) {
            int mid = (start + end) / 2;
            long curSum = getMinSum(n, index, mid);
            if (curSum > maxSum) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return getMinSum(n, index, end) <= maxSum ? end : start;
    }

    private long getMinSum(int n, int index, int val) {
        long sum = 0;
        if (val - index > 0) sum+= (long)(val*2-index) * (index+1) / 2;
        else sum += (long)(1+val)*val/2 + (index+1 - val);

        if (val-n+1+index > 0) sum += (long) (2*val+index-n) * (n-1-index) /2;
        else sum+= (long)val*(val-1)/2 + (n-index-val);

        return sum;
    }
}
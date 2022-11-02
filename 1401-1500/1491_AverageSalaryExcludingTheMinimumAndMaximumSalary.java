class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        int sum = 0;
        for (int k : salary) {
            sum += k;
            min = Math.min(min, k);
            max = Math.max(max, k);
        }

        return (double)(sum - min - max) / (salary.length - 2);
    }
}
class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    public int minDays(int n) {
        if (dp.containsKey(n)) return dp.get(n);
        if (n <= 1) return n;
        int min = Math.min(1 + n % 2 + minDays(n / 2), 1 + n % 3 + minDays(n / 3));  
        dp.put(n, min);
        return min;
    }
}
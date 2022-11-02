class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> count = new HashMap<>();
        int last = 0;
        int max = 0;
        for (int i = 0;i<n;i++) {
            while (count.size() == 2 && !count.containsKey(fruits[i])) {
                int lastCount = count.get(fruits[last]);
                if (lastCount == 1) {
                    count.remove(fruits[last]);
                } else {
                    count.put(fruits[last], lastCount-1);
                }
                last++;
            }
            max = Math.max(i - last + 1, max);
            count.put(fruits[i], count.getOrDefault(fruits[i], 0) + 1);
        }
        return max;

    }
}
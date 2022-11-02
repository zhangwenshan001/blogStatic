class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val == 1) return -1;
            res += (val-1) / 3 + 1;
        }
        return res;
    }
}
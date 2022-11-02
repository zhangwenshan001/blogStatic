class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long res = 0;
        Map<Integer, Long> m = new HashMap<>();
        int i = 0;
        while (i<tasks.length) {
            int task = tasks[i];
            if (!m.containsKey(task) || res + 1 - m.get(task) > space) {
                res++;
                m.put(task, res);
            } else {
                res = res + space - (res - m.get(task)) + 1;
                m.put(task, res);
            }
            i++;
            
        }
        
        return res;
    }
}

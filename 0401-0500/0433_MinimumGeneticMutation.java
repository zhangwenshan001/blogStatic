class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] marked = new boolean[bank.length];
        for (int i = 0;i<bank.length;i++) {
            if (isAdj(startGene, bank[i])) {
                q.add(i);
                marked[i] = true;
            }
        }
        int ans = 1;
        while(q.size() > 0) {
            int size = q.size();
            for (int i = 0;i<size;i++) {
                int cur = q.poll();
                if (endGene.equals(bank[cur])) return ans;
                for (int j = 0;j<bank.length;j++) {
                    if (!marked[j] && isAdj(bank[cur], bank[j])) {
                        q.add(j);
                        marked[j] = true;
                    }
                }
            }
            ans++;
        }
        return -1;

    }

    private boolean isAdj(String s1, String s2) {
        int ans = 0;
        for (int i = 0;i<s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i)) ans++;
        }
        return ans == 1;
    }
}
class Solution {
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        res.add(cur);
        
        while(true) {
            if (cur * 10 <= n) {
                cur = cur * 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur = cur + 1;
            } else if (cur % 10 == 9) {
                cur++;
                while(cur % 10 == 0) {
                    cur = cur / 10;
                }
                if (cur == 1) {
                    break;
                }
            } else if (cur == n) {
                cur = cur / 10 + 1;
                while(cur % 10 == 0) {
                    cur = cur / 10;
                }
                if (cur == 1) {
                    break;
                }
            }
            res.add(cur);
        }
        return res;
    }
}

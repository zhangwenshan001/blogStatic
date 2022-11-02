class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> last = new HashMap<Character, Integer>();
        
        for (int i = 0;i<S.length();i++) {
            last.put(S.charAt(i), i);
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        int pre = -1;
        int curMax = 0;
        for (int i = 0;i<S.length();i++) {
            curMax = Math.max(last.get(S.charAt(i)), curMax);
            if (curMax == i) {
                res.add(curMax - pre);
                pre = curMax;
            }
        }
        
        return res;
        
    }
}
class Solution {
    boolean[] map;
    Map<Integer, Boolean> memo;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        map = new boolean[maxChoosableInteger+1];
        if (desiredTotal <= maxChoosableInteger) return true;
        if (desiredTotal > (1 + maxChoosableInteger)*maxChoosableInteger / 2) return false;
        memo = new HashMap<>();
        return core(maxChoosableInteger, desiredTotal);
    }
    public boolean core(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return false;
        int memoKey = format(map);
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        for (int i = 1;i<=maxChoosableInteger;i++){
            if (map[i]) continue;
            map[i] = true;
            if (!core(maxChoosableInteger, desiredTotal-i)) {
                map[i] = false;
                memo.put(memoKey, true);
                return true;
            }
            map[i] = false;
        }

        memo.put(memoKey, false);
        return false;
    }

    public int format(boolean[] map){
        int num = 0;
        for(boolean b: map){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}
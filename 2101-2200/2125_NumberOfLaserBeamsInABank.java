class Solution {
    public int numberOfBeams(String[] bank) {
        int preCount = 0;
        int ans = 0;
        for (int i = 0;i<bank.length;i++) {
            int curCount = 0;
            for (int j = 0;j<bank[i].length();j++) {
                if (bank[i].charAt(j) == '1') curCount++;
            }
            ans += preCount * curCount;
            if (curCount != 0) preCount = curCount;
        }
        return ans;
    }
}
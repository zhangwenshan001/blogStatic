class Solution {
    // Time complexity O(n)
    // Space complexity O(1)
    public int lengthOfLongestSubstring(String s) {
        int i = -1;
        int j = 0;

        int ans = 0;
        
        int[] charIdx = new int[256];
        Arrays.fill(charIdx, -1);
        while (j < s.length()) {
            int cur = s.charAt(j);
            if (charIdx[cur] >= 0 && charIdx[cur] > i) i = charIdx[cur]; // update i to the index that current char appeared for the last time
            ans = Math.max(ans, j - i);
            charIdx[cur] = j++; // record the index that current char appeared for the last time
        }
        return ans;
    }
}
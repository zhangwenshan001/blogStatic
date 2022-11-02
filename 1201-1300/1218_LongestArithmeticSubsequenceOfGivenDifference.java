class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> numIdx = new HashMap<>();

        for (int i = arr.length-1;i>=0;i--) {
            int tmp = numIdx.getOrDefault(arr[i] + difference, 0) + 1;
            numIdx.put(arr[i], Math.max(tmp, numIdx.getOrDefault(arr[i], 0)));

            ans = Math.max(ans, numIdx.get(arr[i]));
        }
        return ans;
    }
}
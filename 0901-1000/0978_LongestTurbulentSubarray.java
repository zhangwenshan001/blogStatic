class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len == 1) return 1;
        if (len == 2) return arr[0] == arr[1] ? 1 : 2;

        int maxLen = arr[0] == arr[1] ? 1 : 2;
        int start = 0;
        boolean allSame = (arr[0] == arr[1]);
        for (int i = 2;i<len;i++) {
            if (arr[i] != arr[i-1]) {
                maxLen = Math.max(maxLen, 2);
            }
            if (arr[i] > arr[i-1] && arr[i-2] > arr[i-1] || arr[i] < arr[i-1] && arr[i-2] < arr[i-1]) {
                maxLen = Math.max(maxLen, i-start+1);
            } else {
                start = i-1;
            }
        }

        return maxLen;
    }
}
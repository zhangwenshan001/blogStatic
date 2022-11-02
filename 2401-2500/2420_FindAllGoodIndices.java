class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        int[] arr = new int[n - 2 * k];

        if (n - k <= k) return res;

        int preCount = 1;
        int start;
        for (start = 1;start<n-k;start++) {
            if (preCount >= k) {
                arr[start-k] = 1;
            } 
            if (nums[start] > nums[start-1]) {
                preCount = 1;
            } else {
                preCount++;
            }
        }

        int tailCount = 1;
        int end;
        for (end = n-2;end >=k;end--) {
            if (tailCount < k && end-k >=0 && end-k < n - 2 * k) {
                arr[end-k] = 0;
            }

            if (nums[end] > nums[end+1]) {
                tailCount = 1;
            } else {
                tailCount++;
            }
        }
        for (int i = 0;i<arr.length;i++) {
            if (arr[i] > 0) {
                res.add(i+k);
            }
        }
        return res;
    }
}

class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] tmp = new int[k];
        int count = 0;
        int n = arr.length;
        
        for(int i = 0;i<n;i++) {
            int cur = arr[i] % k;
            if (cur < 0) {
                cur = cur + k;
            }
            if (cur == 0) {
                if (tmp[0] == 1) {
                    count++;
                    tmp[0] = 0;
                } else {
                    tmp[0] = 1;
                }
            } else {
                if (tmp[k - cur] >0) {
                    tmp[k - cur]--;
                    count++;
                } else {
                    tmp[cur]++;
                }
            }
        }
        if (count == n / 2) {
            return true;
        } else {
            return false;
        }
    }
}
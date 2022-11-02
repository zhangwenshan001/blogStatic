class Solution {
    public String getPermutation(int n, int k) {
        k--;
        int total = 1;
        for (int i = 1;i<= n-1;i++) total *= i;

        boolean[] nums = new boolean[10];
        StringBuilder sb = new StringBuilder();
        for (int i = n-1;i>0;i--) {
            int curNum = k / total + 1;
            int count = 0, idx = 1;
            while(true) {
                if (!nums[idx]) count++;
                if (count == curNum) {
                    break;
                }
                idx++;
            }
            nums[idx] = true;
            sb.append((char)(idx + '0'));
            k = k % total;
            total /= i;
        }
        for (int i = 1;i<=n;i++) {
            if (!nums[i]) {
                sb.append((char)(i + '0'));
            }
        }
        return sb.toString();
    }
}
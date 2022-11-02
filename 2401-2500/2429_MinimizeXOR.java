class Solution {
    public int minimizeXor(int num1, int num2) {
        int[] num1Bit = new int[30];
        int bitCount = Integer.bitCount(num2);

        int j = 0;
        while(num1 > 0) {
            num1Bit[j++] = num1 & 1;
            num1 = num1 >> 1;
        }
        for (int i = 29;i>=0;i--) {
            if (bitCount == 0) break;
            if (num1Bit[i] == 1) {
                num1Bit[i] = -1;
                bitCount--;
            }
        }
        for (int i = 0;i<30;i++) {
            if (bitCount == 0) break;
            if (num1Bit[i] == 0) {
                num1Bit[i] = -1;
                bitCount--;
            }
        }
        int res = 0;
        for (int i = 29;i>=0;i--) {
            res = (res << 1) + ((num1Bit[i] == -1) ? 1 : 0);
        }
        return res;
    }
}
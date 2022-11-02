class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb = new StringBuilder(s);
        char c;
        int[] move = new int[s.length()+1];
        for (int i = 0;i<shifts.length;i++) {
            int value = shifts[i][2] == 1 ? 1 : -1;
            move[shifts[i][0]] += value;
            move[shifts[i][1]+1] -= value;
        }

        int sum = 0;
        for (int i = 0;i<s.length();i++) {
            sum = (sum + move[i]) % 26;
            if (sb.charAt(i) + sum < 'a') {
                c = (char) (sb.charAt(i) + sum + 26);
            } else if (sb.charAt(i) + sum > 'z') {
                c = (char) (sb.charAt(i) + sum - 26);
            } else {
                 c = (char) (sb.charAt(i) + sum);
            }
            sb.setCharAt(i, c);
        }

        return sb.toString();
    }
}
class Solution {
    public String getHint(String secret, String guess) {
        int[] secretCounts = new int[10];
        int[] guessCounts = new int[10];
        int x = 0;
        for (int i = 0;i<secret.length();i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                x++;
            } else {
                secretCounts[secret.charAt(i) - '0']++;
                guessCounts[guess.charAt(i) - '0']++;
            }
        }

        int y = 0;
        for(int i = 0;i<10;i++) {
            y += Math.min(secretCounts[i], guessCounts[i]);
        }

        return x + "A" + y + "B";

    }
}
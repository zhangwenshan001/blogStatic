class Solution {
    int maxScore = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] charCounts = new int[26];
        for (char c : letters) {
            charCounts[c-'a']++;
        }
        backTracking(words, 0, score, charCounts, 0);
        return maxScore;
    }

    private void backTracking(String[] words, int i, int[] score, int[] charCounts, int preScore) {
        if (i == words.length) {
            maxScore = Math.max(maxScore, preScore);
            return;
        }
        String word = words[i];
        Map<Integer, Integer> curChChouts = new HashMap<>();
        for (int j = 0;j<word.length();j++) {
            curChChouts.put(word.charAt(j) - 'a', curChChouts.getOrDefault(word.charAt(j) - 'a', 0) + 1);
        }
        // use current word
        int[] nextCharCounts = charCounts.clone();
        int curScore = 0;
        boolean canUse = true;
        for(Map.Entry<Integer, Integer> entry : curChChouts.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (nextCharCounts[key] >= count) {
                nextCharCounts[key] -= count;
                curScore += count * score[key];
            } else {
                canUse = false;
                break;
            }
        }
        if (canUse) {
            backTracking(words, i+1, score, nextCharCounts, preScore+curScore);
        }
        // don't use current word
        backTracking(words, i+1, score, charCounts, preScore);
    }
}
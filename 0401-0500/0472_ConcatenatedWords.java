public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> preWords = new HashSet<>();

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String w : words) {
            boolean[] dp = new boolean[w.length()+1];
            dp[0] = true;
            for (int i = 1;i <= w.length();i++) {
                for (int j = i;j>=0; j--) {
                    if (dp[j] && preWords.contains(w.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if (dp[w.length()]) {
                res.add(w);
            } else {
                preWords.add(w);
            }
        }
        return res;
    }
}
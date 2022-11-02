class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        words.add(beginWord);

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        int len = 1;
        while(!words.isEmpty()) {
            Set<String> next = new HashSet<>();
            for (String s : words) {
                if (s.equals(endWord)) {
                    return len;
                }
                for (int i = 0;i<s.length();i++) {
                    char[] chs = s.toCharArray();
                    for (char c = 'a'; c<='z';c++) {
                        chs[i] = c;
                        String ss = new String(chs);

                        if (wordSet.contains(ss)) {
                            next.add(ss);
                            wordSet.remove(ss);
                        }
                    }
                }
            }
            words = next;
            len++;
        }
        return 0;
    }

}
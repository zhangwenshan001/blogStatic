class Solution {

    Map<String, List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for (String w : wordDict) {
            words.add(w);
        }
        return wordBreak(s, words);
    }

    public List<String> wordBreak(String s, Set<String> dict) {
        if (cache.containsKey(s)) return cache.get(s);
        List<String> result = new ArrayList<>();
        
        if (dict.contains(s)) result.add(s);

        for (int i = 1;i<s.length();i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (dict.contains(left)) {
                List<String> next = wordBreak(right, dict);
                for (String ss : next) {
                    result.add(left + " " + ss);
                }
            }
        }
        cache.put(s, result);
        return result;
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.asList(strs)
        .stream().collect(Collectors.groupingBy(s -> {
            char[] counts = new char[26];
            for(char c : s.toCharArray()) counts[c - 'a']++;
            return String.valueOf(counts);
        })).values());
    }
}
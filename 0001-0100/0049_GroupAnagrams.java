class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs).collect(Collectors.groupingBy(
                s -> s.chars().boxed().collect(
                    Collectors.groupingBy(Function.identity(), Collectors.counting()))))
                    .values().stream()
            .collect(Collectors.toList());
    }
}
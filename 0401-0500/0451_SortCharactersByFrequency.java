class Solution {
    public String frequencySort(String s) {
        return s.chars().mapToObj(c -> (char) c) 
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream() 
        .sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue()))
        .reduce(
            "",
            (res, e) -> res + String.valueOf(e.getKey()).repeat(e.getValue().intValue()),
            (a, b) -> a + b
        );
    }
}
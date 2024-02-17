class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        return Arrays.stream(arr).boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream().map(e -> e.getValue().intValue())
        .sorted((v1, v2) -> v1 - v2).reduce(
            new int[]{k, 0},
            (res, v) -> {
                if (res[0] >= v) return new int[]{res[0] - v, res[1]};
                return new int[]{res[0], res[1]+1};
            },
            (a,b) -> b
            )[1];
    }
}
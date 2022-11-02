class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();


        for(int i=0;i< groupSizes.length;i++) {
            int k = groupSizes[i];
            if (map.containsKey(k)) {
                map.get(k).add(i);
            } else {
                  List<Integer> cur = new ArrayList<>();
                  cur.add(i);
                  map.put(k, cur);
            }
            if (map.get(k).size() == k) {
                List<Integer> cur = map.get(k);
                ans.add(cur);
                map.put(k, new ArrayList<Integer>());
            } 
        }
        return ans;
    }
}
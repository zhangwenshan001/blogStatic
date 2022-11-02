class Solution {
    Set<String> strSet = new HashSet<>();
    int max = 0;
    public int maxUniqueSplit(String s) {
        split(s, 0, 0);
        return max;
    }

    private void split(String s, int last, int cur) {
        if (cur >= s.length()) return;

        String sub = s.substring(last, cur+1);

        // if last one
        if (cur == s.length()-1) {
            // if sub exists, split failed
            if (strSet.contains(sub)) return; 
            max = Math.max(max, strSet.size()+1);
            return;
        }

        // split at current place
        if (!strSet.contains(sub)) {
            strSet.add(sub);
            split(s, cur+1, cur+1);
            strSet.remove(sub);
        }
        // not split at current place
        split(s, last, cur+1);
    }
}
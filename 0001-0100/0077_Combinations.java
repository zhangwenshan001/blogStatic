class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineFrom(n, k, 1);    
        return ans;
    }


    private void combineFrom(int n, int k, int i) {
        if (i > n) return;
        // choose current
        cur.add(i);
        if (cur.size() == k) {
            ans.add(new ArrayList<Integer>(cur));
        } else {
            combineFrom(n,k,i+1);
        }

        cur.remove(cur.size()-1);

        // skip current
        combineFrom(n,k,i+1);
    }
}
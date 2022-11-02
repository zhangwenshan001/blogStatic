class Solution {
    public String decodeAtIndex(String s, int k) {
        List<Integer> lengths = new ArrayList<>();
        lengths.add(1);
        int idx = 1;
        while(true) {
            long next;
            if (s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') {
                next = lengths.get(idx-1) + 1;
                if (next == k) return s.substring(idx,idx+1);
            } else {
                next = (long)lengths.get(idx-1) * (s.charAt(idx) - '0');
            }
            // System.out.println(idx + " " + s.charAt(idx) + " " + next);
            if (next >= k) break;
            lengths.add((int) next);
            idx++;
        }
        if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            if (k % lengths.get(idx-1) == 0) k = lengths.get(idx-1);
            else k = k % lengths.get(idx-1);
        }
        for (int i = lengths.size()-1;i>=0;i--) {
            // System.out.println(k + " " + s.charAt(i));
            if (k == 1) return s.substring(0,1);
            if (k == lengths.get(i) && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') return s.substring(i,i+1);
            if (k == lengths.get(i) && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                k = k / (s.charAt(i) - '0');
            } else if (k < lengths.get(i) && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (k % lengths.get(i-1) == 0) k = lengths.get(i-1);
                else k = k % lengths.get(i-1);
            }
        }

        return new String();
    }
}
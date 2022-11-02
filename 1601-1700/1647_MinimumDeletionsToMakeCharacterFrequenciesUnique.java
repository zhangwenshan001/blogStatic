class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (int i = 0;i<s.length();i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int ans = 0;

        Arrays.sort(freq);
        Set<Integer> freqSet = new HashSet<>();
        for (int k : freq) {
            if (!freqSet.contains(k)) freqSet.add(k);
            else {
                int f = k;
                while(freqSet.contains(f) && f > 0) {
                    f--;
                }
                ans += (k-f);
                if (f > 0) freqSet.add(f);
            }
        }
        return ans;
    }
}
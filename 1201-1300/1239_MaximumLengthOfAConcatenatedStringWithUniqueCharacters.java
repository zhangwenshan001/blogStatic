class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        int[][] counts = new int[arr.size()][26];
        int[] chs = new int[26];
        for (int i = 0;i<arr.size();i++) {
            int len = arr.get(i).length();
            for (int j = 0; j < len;j++) {
                counts[i][arr.get(i).charAt(j) - 'a']++; 
            }
        }
        backTracking(counts, chs, 0);
        return max;
    }

    private void backTracking(int[][] counts, int[] chs, int i) {
        if (i == counts.length) {
            int cur = 0;
            for (int k : chs) {
                if (k == 1) cur++;
            }
            max = Math.max(max, cur);
            return;
        }
        
        // if current String is not selected
        backTracking(counts, chs, i+1);
        
        // if current String is selected 
        boolean valid = true;
        for (int j = 0;j<26;j++) {
            if (chs[j] + counts[i][j] > 1) {
                valid = false;
                break;
            }
        }

        if (valid) {
            for (int j = 0;j<26;j++) {
                chs[j] += counts[i][j];
            }

            backTracking(counts, chs, i+1);

            for (int j = 0;j<26;j++) {
                chs[j] -= counts[i][j];
            }
        }
    }
}
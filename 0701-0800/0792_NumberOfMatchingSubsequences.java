class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Boolean> tmp = new HashMap<String, Boolean>();
        int count = 0;
        for (String word : words) {
            if (tmp.containsKey(word)) {
                if (tmp.get(word)) {
                    count++;
                }
            } else {
                if (isSubseq(s, word)) {
                    tmp.put(word, true);
                    count++;
                } else {
                    tmp.put(word, false);
                }
            }
        }
        
        return count;
    }
    
    
    public boolean isSubseq(String s, String word) {
        int i = 0;
        int j = 0;
        
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            } 
            i++;
        }
        
        if (j == word.length()) {
            return true;
        }
        
        return false;
    }
}
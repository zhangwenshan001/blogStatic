class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        
        for(int i =0;i<d.size();i++) {
            if (check(s, d.get(i))) {
                if (d.get(i).length() == res.length()) {
                    res = (d.get(i).compareTo(res) < 0) ? d.get(i) : res;
                } else {
                    res = d.get(i).length() >  res.length() ? d.get(i) : res;
                }
                
            }
        }
        
        return res;
    }
    
    public Boolean check(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 == 0 || len2 == 0) {
            return false;
        }
        
        int i = 0, j = 0;
        while(true) {
            if (s2.charAt(j) == s1.charAt(i)) {
                i++;
                j++;
            } else {
                i++;
            }
            
            if (j == len2) {
                return true;
            }
            if (i == len1) {
                return false;
            }
        }
    }
}
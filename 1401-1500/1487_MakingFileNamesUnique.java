class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String,Integer> dict = new HashMap<String, Integer>();
        Set<String> files = new HashSet<String>();
        
        int n = names.length;
        String[] res = new String[n];
        for(int i = 0;i<n;i++) {
            if (!files.contains(names[i])) {
                res[i] = names[i];
                files.add(names[i]);
                dict.put(names[i], dict.getOrDefault(names[i], 0)+1);   
            } else {
                int count = dict.getOrDefault(names[i], 0);
                while(files.contains(names[i] + "(" + count + ")")) {
                    count++;
                }
                dict.put(names[i], count);
                res[i] = names[i] + "(" + count + ")";
                dict.put(res[i], dict.getOrDefault(res[i], 0)+1);
                files.add(res[i]);
            }
        }
        
        return res;
    }
}
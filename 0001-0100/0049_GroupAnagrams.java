class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>() ;

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            String key = stringSort(s);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> curList = new ArrayList<String>();
                curList.add(s);
                map.put(key, curList);
            }
        }

        for (List<String> list : map.values()) {
            result.add(list);
        }

        return result;
    }
    
    public static String stringSort(String s) {
        char[] chs = s.toCharArray();

        Arrays.sort(chs);

        return (new String(chs));
    }
}
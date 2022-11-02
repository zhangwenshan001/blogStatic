class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null || wordDict==null) {
			return false;
		}
		int sLen = s.length();
		List<Integer> trueIndex = new ArrayList<Integer>();

		for(int i =0;i<sLen;i++) {
			if (wordDict.contains(s.substring(0, i+1))) {
				trueIndex.add(i);
				continue;
			}
			for(int j = trueIndex.size()-1;j>=0;j--) {
				if (wordDict.contains(s.substring(trueIndex.get(j) + 1, i+1))) {
					trueIndex.add(i);
					break;
				}
			}
		}
		return trueIndex.contains(sLen-1);
	}
}
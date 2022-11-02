class CombinationIterator {

    protected int[] curIndexs;
    protected String characters;
    protected boolean hasNext;
    
    public CombinationIterator(String characters, int combinationLength) {
        hasNext = true;
        curIndexs = new int[combinationLength];
        this.characters = characters;
        for (int i = 0;i<combinationLength;i++) {
            curIndexs[i] = i;
        }
        
    }
    
    public String next() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curIndexs.length; i++) {
            sb.append(characters.charAt(curIndexs[i]));
        }
        
        boolean flag = false;
        for (int i=0;i<curIndexs.length;i++) {
            if (curIndexs[curIndexs.length-1-i] != characters.length()-1-i) {
                flag = true;
                curIndexs[curIndexs.length-1-i]++;
                for (int j = curIndexs.length-i;j<curIndexs.length;j++) {
                    curIndexs[j] = curIndexs[j-1]+1;
                }
                break;
            }
        }
        
        if (!flag) {
            hasNext = false;
        }
        return sb.toString();
        
    }
    
    public boolean hasNext() {
        return hasNext;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
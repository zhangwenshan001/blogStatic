class Trie {
    Node[] chs;
    public Trie() {
        chs = new Node[26];
    }
    
    public void insert(String word) {
        Node[] tmp = chs;
        for (int i = 0;i<word.length();i++) {
            int ch = (int)(word.charAt(i) - 'a');
            if (tmp[ch] == null) {
                Node cur = new Node(ch, i == word.length()-1);
                tmp[ch] = cur;
            } else {
                tmp[ch].isEnd = tmp[ch].isEnd || (i == word.length()-1);
            }
            tmp = tmp[ch].next;
        }

        // System.out.println(chs[0].next['p'-'a'].next['p'-'a'].isEnd);
    }
    
    public boolean search(String word) {
        Node[] tmp = chs;
        for (int i = 0;i<word.length();i++) {
            int ch = (int)(word.charAt(i) - 'a');
            if (tmp[ch] == null) return false;
            if (i == word.length()-1) {
                return tmp[ch].isEnd;
            }
            tmp = tmp[ch].next;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node[] tmp = chs;
        for (int i = 0;i<prefix.length();i++) {
            int ch = (int)(prefix.charAt(i) - 'a');
            if (tmp[ch] == null) return false;
            tmp = tmp[ch].next;
        }
        return true;
    }
}

class Node {
    int idx;
    boolean isEnd;
    Node[] next = new Node[26];

    public Node(int idx, boolean isEnd) {
        this.idx = idx;
        this.isEnd = isEnd;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
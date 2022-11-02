class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node(' ');
    }
    
    public void addWord(String word) {
        Node pre = root;
        for (int i = 0;i<word.length();i++) {
            char c = word.charAt(i);
            if (pre.next[c - 'a'] == null) {
                Node newNode = new Node(c);
                pre.next[c - 'a'] = newNode;
            } 
            if (i == word.length() - 1) {
                pre.next[c - 'a'].isWordEnd = true;
            }
            pre = pre.next[c - 'a'];
        }
    }
    
    public boolean search(String word) {
        return searchFrom(word, 0, root);
    }

    private boolean searchFrom(String word, int i, Node pre) {
        if (pre == null) return false;
        if (i == word.length()-1) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (int j = 0;j<26;j++) {
                    if (pre.next[j] != null && pre.next[j].isWordEnd) return true;
                }
                return false;
            } else {
                return pre.next[ch- 'a'] != null && pre.next[ch- 'a'].isWordEnd;
            }
        }
        char ch = word.charAt(i);
        if (ch == '.') {
            for (int j= 0;j<26;j++) {
                if (searchFrom(word, i+1, pre.next[j])) return true;
            }
            return false;
        }

        if (pre.next[ch - 'a'] == null) return false;
        return searchFrom(word, i+1, pre.next[ch - 'a']);
    }


}

class Node {
    char ch;
    Node[] next = new Node[26];
    boolean isWordEnd = false;

    public Node(char ch) {
        this.ch = ch;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
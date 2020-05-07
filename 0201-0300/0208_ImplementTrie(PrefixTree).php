class Trie {
    /**
     * Initialize your data structure here.
     */
    private $dataArray;
    
    function __construct() {
        $this->dataArray = [];    
    }
  
    /**
     * Inserts a word into the trie.
     * @param String $word
     * @return NULL
     */
    function insert($word) {
        if (!in_array($word, $this->dataArray)) {
            $this->dataArray[] = $word;
        }
    }
  
    /**
     * Returns if the word is in the trie.
     * @param String $word
     * @return Boolean
     */
    function search($word) {
        return in_array($word, $this->dataArray);
    }
  
    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param String $prefix
     * @return Boolean
     */
    function startsWith($prefix) {
        $count = count($this->dataArray);
        for($i =0;$i<$count;$i++) {
            if (0 === strpos($this->dataArray[$i], $prefix)) {
                return true;
            } 
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * $obj = Trie();
 * $obj->insert($word);
 * $ret_2 = $obj->search($word);
 * $ret_3 = $obj->startsWith($prefix);
 */

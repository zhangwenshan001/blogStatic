<?php 
class TrieNode 
{
    public $isEnd = true;
    public $children = [];
    
    function __construct() {
        $this->isEnd = false;
    }
}


class WordDictionary {
    public $node = null;
    /**
     * Initialize your data structure here.
     */
    function __construct() 
    {
        $this->node = new TrieNode();
    }
  
    /**
     * Adds a word into the data structure.
     * @param String $word
     * @return NULL
     */
    function addWord(string $word) 
    {
        $count = strlen($word);
        $node = $this->node;
        for ($i = 0; $i < $count; $i++) {
            $char = $word[$i];
            if (array_key_exists($char, $node->children)) {
                $node = $node->children[$char];
                continue;
            }
            $node->children[$char] = new TrieNode();
            $node = $node->children[$char];
        }
        $node->isEnd = true;
    }
  
    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     * @param String $word
     * @return Boolean
     */
    function search(string $word, $node = null): bool
    {     
        if (!$node) {
            $node = $this->node;
        }
        $count = strlen($word);
        
        for ($i = 0; $i < $count; $i++) {
            $character = $word[$i];
            if ($character === '.') {
                $subString = substr($word, $i+1);
                foreach ($node->children as $child => $childNode) {
                    if ($this->search($subString, $childNode)) {
                        return true;
                    }
                }
                return false;
            }
            if (array_key_exists($character, $node->children)) {
                $node = $node->children[$character];
                continue;
            }
            return false;    
        }
        return $node->isEnd;
    }
}

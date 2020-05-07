<?php

class Solution {
    private $delNum = 0;
    private $s;

    /**
     * @param String $s
     * @return Boolean
     */
    function validPalindrome($s) {
        $this->s = $s;
        return $this->validPalindromeHandle(0, strlen($s)-1);
    }
    
    function validPalindromeHandle($start, $end) {
        if ($start >= $end) {
            return true;
        }
        
        if ($this->s[$start] == $this->s[$end]) {
            return $this->validPalindromeHandle($start+1, $end-1);
        }
        
        if ($this->delNum > 0) {
            return false;
        }
        
        $this->delNum++;
        return $this->validPalindromeHandle($start+1, $end) || $this->validPalindromeHandle($start, $end-1);
    }
}

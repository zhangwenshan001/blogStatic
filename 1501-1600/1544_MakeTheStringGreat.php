<?php

class Solution {

    /**
     * @param String $s
     * @return String
     */
    function makeGood($s) {
        $stack = [];
        
        $slen = strlen($s);
        
        for($i = 0 ;$i< $slen;$i++) {
            if (count($stack) == 0) {
                $stack[] = $s[$i];
                continue;
            }
            
            $curChar = $s[$i];
            if (ord($stack[count($stack)-1]) - ord($curChar) == 32 || ord($curChar) - ord($stack[count($stack)-1]) == 32) {
                array_pop($stack);
            } else {
                $stack[] = $s[$i];
            }
            var_dump($stack);
           
        }
        
        return implode('', $stack);
    }
}

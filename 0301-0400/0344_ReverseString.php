<?php

class Solution {

    /**
     * @param String[] $s
     * @return NULL
     */
    function reverseString(&$s) {
        $slen = count($s);
        
        $i = 0;
        $j = $slen-1;
        while($i < $j) {
            $s[$i] = chr(ord($s[$i]) + ord($s[$j]));
            $s[$j] = chr(ord($s[$i]) - ord($s[$j]));
            $s[$i] = chr(ord($s[$i]) - ord($s[$j]));
            $i++;
            $j--;
        }
        
        return;    
    }
}

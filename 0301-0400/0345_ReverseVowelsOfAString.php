<?php

class Solution {

    /**
     * @param String $s
     * @return String
     */
    function reverseVowels($s) {
        $vowels = ['a','e','i','o','u','A','E','I','O','U'];
        
        $start = 0;
        $end = strlen($s)-1;
        
        while($start < $end) {
            while(!in_array($s[$start], $vowels) && $start < $end) {
                $start++;
            }
            while(!in_array($s[$end], $vowels) && $start < $end) {
                $end--;
            }
            
            $tmp = $s[$start];
            $s[$start] = $s[$end];
            $s[$end] = $tmp;
            $start++;
            $end--;
        }
        
        return $s;
    }
}

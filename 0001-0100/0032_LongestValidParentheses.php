<?php

class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function longestValidParentheses($s) {
       if (!$s) {
            return 0;
        }

        $slen = strlen($s);
        $tmp  = [-1]; 
        $max  = 0;

        $i = 0;
        while ($i < $slen) {
            $last = end($tmp);
        

            if ($s[$i] == ')') {
                if ($last < 0) {
                    $max =  max($max, $this->longestValidParentheses(substr($s, $i + 1, $slen - 1 - $i)));
                    break;
                } else {
                   
                    array_pop($tmp);
                    $max = max($max, $i - end($tmp));
                }
            } else {
                array_push($tmp, $i); 
            }
            $i++;

        }

        return $max;
    }
}

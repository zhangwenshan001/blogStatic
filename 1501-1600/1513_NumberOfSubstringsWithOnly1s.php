<?php
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function numSub($s) {
        $slen = strlen($s);
        
        $i = 0;
        $cur = 0;
        $total = 0;
        while($i < $slen) {
            if ($s[$i] == '0') {
                $cur = 0;
            } else {
                $cur++;
                if ($i == $slen - 1 || $s[$i+1] == '0') {
                    if ($cur % 2 == 0) {
                        $total = (($cur+1) * ($cur / 2) % 1000000007 + $total) % 1000000007;
                    } else {
                        $total = ((($cur+1) / 2  * $cur) % 1000000007 + $total) % 1000000007;
                    }
                }
            }
            $i++;
        }
        
        return $total;
    }
}

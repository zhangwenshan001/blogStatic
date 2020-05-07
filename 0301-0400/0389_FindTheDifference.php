<?php

class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return String
     */
    function findTheDifference($s, $t) {
        $slen =strlen($s);
        $map = array_fill(0, 25, 0);
        $aOrd = ord('a');
        for($i = 0;$i<$slen;$i++) {
            $o = ord($s[$i]);
            $map[$o-$aOrd]++;
        }
        
        $tlen = strlen($t);
        for($i =0;$i<$tlen;$i++) {
            $o = ord($t[$i]);
            if (--$map[$o-$aOrd] <0) {
                return $t[$i];
            }
        }
        
        return "";
    }
}

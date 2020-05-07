<?php

class Solution {

    /**
     * @param String $s
     * @param Integer $k
     * @return Boolean
     */
    function hasAllCodes($s, $k) {
        $slen = strlen($s);
        if ($slen < $k) {
            return false;
        }
        $map = [];
        for($i = $k-1;$i<$slen;$i++) {
            $curStr = substr($s, $i-$k+1, $k);
            $map[$curStr] = 1;
        }

        return count($map) == (1 << $k);

    }
}
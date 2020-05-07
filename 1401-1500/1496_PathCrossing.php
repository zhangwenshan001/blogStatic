<?php

class Solution {

    /**
     * @param String $path
     * @return Boolean
     */
    function isPathCrossing($path) {
        $map = [];
        $map[0][0] = 1;
        
        $i = 0;
        $j = 0;
        
        $slen = strlen($path);
        for($k = 0;$k<$slen;$k++) {
            if ($path[$k] == 'N') {
                if (isset($map[$i][++$j])) {
                    return true;
                } else {
                    $map[$i][$j] = 1;
                }   
            }
            if ($path[$k] == 'S') {
                if (isset($map[$i][--$j])) {
                    return true;
                } else {
                    $map[$i][$j] = 1;
                }   
            }
            if ($path[$k] == 'E') {
                if (isset($map[--$i][$j])) {
                    return true;
                } else {
                    $map[$i][$j] = 1;
                }   
            }
            if ($path[$k] == 'W') {
                if (isset($map[++$i][$j])) {
                    return true;
                } else {
                    $map[$i][$j] = 1;
                }   
            }
        }
        
        return false;
    }
}

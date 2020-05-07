<?php

class Solution {

    /**
     * @param Integer[] $arr
     * @param Integer $start
     * @return Boolean
     */
    function canReach($arr, $start) {
        if ($arr[$start] == 0) {
            return true;
        }
        $map = [];
        $next = [$start];
        
        while(!empty($next)) {
            $cur = current($next);
            
            if (!empty($map[$cur])) {
                array_shift($next);
                continue;
            }
            
            $map[$cur] = 1;
            if ($cur - $arr[$cur] >= 0) {
                if ($arr[$cur - $arr[$cur]] == 0) {
                    return true;
                } else {
                    $next[] = $cur - $arr[$cur];
                }
            }
            
            if ($cur + $arr[$cur] <count($arr)) {
                if ($arr[$cur + $arr[$cur]] == 0) {
                    return true;
                } else {
                    $next[] = $cur + $arr[$cur];
                }
            }
            array_shift($next);
                
        }
        return false;
    }
}

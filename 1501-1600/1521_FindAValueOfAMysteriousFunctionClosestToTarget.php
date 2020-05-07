<?php
class Solution {

    /**
     * @param Integer[] $arr
     * @param Integer $target
     * @return Integer
     */
    function closestToTarget($arr, $target) {
        $n = count($arr);     
        $min = PHP_INT_MAX;
        
        for($i = 0;$i<$n;$i++) {
            $ans = $arr[$i];
            for($j = $i;$j<$n;$j++) {
                $ans = $ans & $arr[$j];
                $min = min($min, abs($ans-$target));
                
                if ($min == 0) return $min;
                if ($ans < $target) break;
            }
            
            if ($ans > $target) break;
            
        }
        
        return $min;
    }
}

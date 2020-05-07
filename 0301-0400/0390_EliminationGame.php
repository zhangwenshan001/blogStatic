<?php 

class Solution {
    /**
     * @param Integer $n
     * @return Integer
     */
    function lastRemaining($n) {
        $head = 1;
        $step = 1;
        $left = true;
        $remaining = $n;
        
        while($remaining > 1) {
            if ($left  || $remaining % 2 == 1) {
                $head += $step;
            }
            $remaining = (int) ($remaining / 2);
            $step = $step * 2;
            $left = !$left;
        }
        
        return $head;
    }
}

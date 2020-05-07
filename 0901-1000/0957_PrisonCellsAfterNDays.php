<?php

class Solution {

    /**
     * @param Integer[] $cells
     * @param Integer $N
     * @return Integer[]
     */
    function prisonAfterNDays($cells, $N) {
        $n = count($cells);
        $t = [];
        
        while($N > 0) {
            $t[implode("", $cells)] = $N--; 
            $tmp = [];
            $tmp[0] = 0;
            for($i = 1;$i<$n-1;$i++) {
                $tmp[$i] = ($cells[$i-1] == $cells[$i+1]) ? 1 : 0;
            }
            $tmp[$n-1] = 0;
            $cells = $tmp;
            
            if (key_exists(implode("", $cells), $t)) {
                $N = $N % ($t[implode("", $cells)] - $N);
            }
        }
        
        return $cells;
    }
}

<?php

class Solution {

    private $dp = [];
    
    /**
     * @param Integer[] $piles
     * @return Integer
     */
    function stoneGameII($piles) {
        $sum = 0;
        foreach($piles as $pile) {
            $sum = $sum + $pile;
        }
        
        $res = $this->stoneGameIIHandle($piles, 0, count($piles)-1, 1);
        return ($sum + $res) / 2;
    }
    
    function stoneGameIIHandle($piles, $start, $end, $M) {
        if (isset($this->dp[$start][$end][$M])) {
            return $this->dp[$start][$end][$M];
        }
        
        if ($end - $start + 1 <= 2 * $M) {
            $s = 0;
            for($i =$start;$i<=$end;$i++) {
                $s += $piles[$i];
            }
            return $s;
        }
        
        $max = PHP_INT_MIN;
        for($i = 0;$i<2*$M;$i++) {
            $s = 0;
            for($j =0;$j<=$i;$j++) {
                $s += $piles[$start+$j];
            }
           
            $max = max($s - $this->stoneGameIIHandle($piles, $start+$i+1, $end, max($M, $i+1)), $max);
        }
        
        $this->dp[$start][$end][$M] = $max;
        
        return $this->dp[$start][$end][$M];
    }
    
}

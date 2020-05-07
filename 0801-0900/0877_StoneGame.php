<?php

class Solution {

    private $dp = [];
    /**
     * @param Integer[] $piles
     * @return Boolean
     */
    function stoneGame($piles) {
        $max = $this->stoneGameHandle($piles, 0, count($piles)-1);
        if ($max > 0) {
            return true;
        } 
        
        return false;
    }
    
    function stoneGameHandle($piles, $start, $end) {
        if (isset($this->dp[$start][$end])) {
            return $this->dp[$start][$end];
        }
        if ($start == $end) {
            $this->dp[$start][$end] = $piles[$start];
            return $piles[$start];
        }
        
        $this->dp[$start][$end] = max($piles[$start] - $this->stoneGameHandle($piles, $start + 1, $end),
                                          $piles[$end] - $this->stoneGameHandle($piles, $start, $end-1));

        
        return $this->dp[$start][$end];
    }
}

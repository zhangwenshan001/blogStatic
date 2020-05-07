<?php

class Solution {

    private $memo = [];
    private $nums;
    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function maxCoins($nums) {
        $c = count($nums);
        $nums[-1] = 1;
        $nums[$c] = 1;
        $this->nums = $nums;
        
        return $this->burst(-1, $c);
    }
    
    function burst($left, $right) {
        if ($left + 1 == $right) {
            return 0;
        }
        if (!empty($this->memo[$left][$right])) {
            return $this->memo[$left][$right];
        }
        
        $cur = 0;
        for($i = $left + 1;$i<$right;$i++) {
            $cur = max($cur, $this->nums[$left] * $this->nums[$i] * $this->nums[$right] + 
                      $this->burst($left, $i) + $this->burst($i,$right));
        }
        $this->memo[$left][$right] = $cur;
        
        return $cur;
    }
}

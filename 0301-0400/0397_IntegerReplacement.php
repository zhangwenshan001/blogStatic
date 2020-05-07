<?php
class Solution {
    private $dp = [];
    
    /**
     * @param Integer $n
     * @return Integer
     */
    function integerReplacement($n) {
        $this->dp[0] = 0;
        $this->dp[1] = 0;
        if($n<=1) {
            return 0;
        }
        return $this->handle($n);
    }
    
    function handle($n) {
        if (isset($this->dp[$n])) {
            return $this->dp[$n];
        }
        
        if ($n % 2 == 0) {
            $this->dp[$n] = $this->handle($n / 2) + 1;
        } else {
            $this->dp[$n] = min($this->handle($n-1), $this->handle($n+1)) + 1;
        }
        
        return $this->dp[$n];
    }
}

<?php

class Solution {

    private $dp = [];
    
    /**
     * @param String $s1
     * @param String $s2
     * @return Integer
     */
    function minimumDeleteSum($s1, $s2) {
        return $this->handle($s1,$s2,0,0);
    }
    
    function handle($s1, $s2, $i, $j) {
        if(!empty($this->dp[$i][$j])) {
            return $this->dp[$i][$j];
        }
        
        if ($i == strlen($s1) && $j == strlen($s2)) {
            return 0;
        } else if ($i == strlen($s1)) {
            $this->dp[$i][$j] = ord($s2[$j]) + $this->handle($s1, $s2, $i, $j+1);
        } else if ($j == strlen($s2)) {
            $this->dp[$i][$j] = ord($s1[$i]) + $this->handle($s1, $s2, $i+1, $j);
        } else {
            if ($s1[$i] == $s2[$j]) {
                $this->dp[$i][$j] = $this->handle($s1, $s2, $i+1, $j+1);
            } else {
                $this->dp[$i][$j] = min(ord($s2[$j]) + $this->handle($s1,$s2, $i, $j+1), ord($s1[$i]) + $this->handle($s1, $s2, $i+1, $j));
            }
        }  
        return $this->dp[$i][$j];
    }
}

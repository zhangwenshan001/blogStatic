<?php
class Solution {
    private $bloomDay;
    private $k;
    private $length;
    private $dp = [];

    /**
     * @param Integer[] $bloomDay
     * @param Integer $m
     * @param Integer $k
     * @return Integer
     */
    function minDays($bloomDay, $m, $k) {
        $n = count($bloomDay);
        $left = 1;
        $right = 1000000000;
        if ($m * $k > $n) {
            return -1;
        }
        while($left < $right) {
            $mid = (int) (($left + $right) / 2);
            $flow = 0;
            $bouq = 0;
            
            for($j = 0;$j<$n;$j++) {
                if ($bloomDay[$j] > $mid) {
                    $flow = 0;
                } else if (++$flow >= $k) {
                    $bouq++;
                    $flow = 0;
                }
            }
            
            if ($bouq < $m) {
                $left = $mid + 1;
            } else {
                $right = $mid;
            }
        }
        
        return $left;
    }
    
    function minDaysDp($bloomDay, $m, $k) {
        $this->bloomDay = $bloomDay;
        $this->k = $k;
        $this->length = count($bloomDay);
        $res = $this->handle(0, $m);
        if ($res == PHP_INT_MAX) {
            return -1;
        }
        
        return $res;
    }
    
    function handle($start, $c) {
        if (isset($this->dp[$start][$c])) {
            return $this->dp[$start][$c];
        }
        if ($start + $c *$this->k > $this->length) {
            return PHP_INT_MAX;
        }
        
        $max = PHP_INT_MIN;
        for($i = 0;$i<$this->k;$i++) {
            $max = max($max, $this->bloomDay[$start+$i]);
        }
    
        if ($c == 1) {
            $this->dp[$start][$c] = min($this->handle($start+1, $c), $max);
        } else {
             $this->dp[$start][$c] = min($this->handle($start+1, $c), max($max, $this->handle($start+$this->k, $c-1)));
        }
        return $this->dp[$start][$c];
    }
}
